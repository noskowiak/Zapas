package pl.zapas.service.subiekt;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zapas.dtos.subiekt.StockSubiektDto;
import pl.zapas.entity.subiekt.StockSubiekt;
import pl.zapas.mapper.subiekt.StockSubiektMapper;
import pl.zapas.repository.subiekt.StockSubiektRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockSubiektService {

    private final StockSubiektRepository stockSubiektRepository;
    private final StockSubiektMapper stockSubiektMapper;

    public List<StockSubiektDto> findAll() {
        return stockSubiektRepository.findAll()
                .stream()
                .map(stockSubiektMapper::toDto)
                .collect(Collectors.toList());

    }

    public StockSubiektDto loadProductBySymbol(final String symbol) {
        return stockSubiektMapper.toDto(stockSubiektRepository.findStockSubiektByProductSymbol(symbol));
    }

    public StockSubiektDto[] retrieveStockSubiekt() {
        return WebClient
                .builder().exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))
                        .build()).build()
                .get()
                .uri("http://localhost:8080/stock-subiekt")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StockSubiektDto[].class).block();
    }

    public StockSubiektDto[] save() {
        StockSubiektDto[] stockSubiektDtos = retrieveStockSubiekt();
        for (StockSubiektDto stockSubiektDto: stockSubiektDtos) {
            stockSubiektRepository.save(stockSubiektMapper.toEntity(stockSubiektDto));
        }
        return stockSubiektDtos;
    }

}
