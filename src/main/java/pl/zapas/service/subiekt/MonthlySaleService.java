package pl.zapas.service.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.entity.subiekt.MonthlySale;
import pl.zapas.entity.subiekt.Product;
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


}
