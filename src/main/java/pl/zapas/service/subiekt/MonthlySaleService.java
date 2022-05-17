package pl.zapas.service.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.subiekt.MonthlySale;
import pl.zapas.entity.subiekt.Product;
import pl.zapas.repository.subiekt.MonthlySaleRepository;


import java.util.List;

@Service
@RequiredArgsConstructor

public class MonthlySaleService {

    private final MonthlySaleRepository monthlySaleRepository;
    private final Product product;

    public List<MonthlySale> findAll() { return monthlySaleRepository.findAll();}

    public MonthlySale loadMonthlyBySymbol(final String symbol) {
        return monthlySaleRepository
                .findMonthlySaleByProduct(symbol);
    }

   /* public String loadProductBySymbol(final String symbol) {
        return monthlySaleRepository.findProductBySymbol(symbol)
                .map(Product::getSymbol)
                .orElseThrow();
    }*/

}
