package pl.zapas.service.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.mapper.subiekt.MonthlySaleMapper;
import pl.zapas.repository.subiekt.MonthlySaleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class MonthlySaleService {

    private final MonthlySaleRepository monthlySaleRepository;
    private final MonthlySaleMapper monthlySaleMapper;


    public List<MonthlySaleDto> findAll() {
        return monthlySaleRepository.findAll()
                .stream()
                .map(monthlySaleMapper::toDto)
                .collect(Collectors.toList());
    }

    public MonthlySaleDto loadMonthlyBySymbol(final String symbol) {
        return monthlySaleMapper.toDto(monthlySaleRepository.findMonthlySaleByProductSymbol(symbol));
    }


    public MonthlySaleDto[] retrieveMonthlySale() {

        return WebClient
                .builder().exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))
                        .build()).build()
                .get()
                .uri("http://localhost:8080/monthly-sale")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(MonthlySaleDto[].class).block();
    }

    public MonthlySaleDto[] save() {

        MonthlySaleDto[] monthlySaleDtos = retrieveMonthlySale();
        for (MonthlySaleDto monthlySaleDto : monthlySaleDtos) {
            monthlySaleRepository.save(monthlySaleMapper.toEntity(monthlySaleDto));
        }

        return monthlySaleDtos;
    }

}
