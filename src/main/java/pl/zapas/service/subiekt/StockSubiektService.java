package pl.zapas.service.subiekt;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

}
