package pl.zapas.service.subiekt;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.subiekt.StockSubiekt;
import pl.zapas.repository.subiekt.StockSubiektRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockSubiektService {

    private final StockSubiektRepository stockSubiektRepository;

    public List<StockSubiekt> findAll() {
        return stockSubiektRepository.findAll();
    }

    public StockSubiekt loadProductBySymbol(final String symbol) {
        return stockSubiektRepository.findStockSubiektByProductSymbol(symbol);
    }

}
