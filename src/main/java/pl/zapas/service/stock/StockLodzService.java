package pl.zapas.service.stock;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.stock.StockLodz;
import pl.zapas.repository.stock.StockLodzRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StockLodzService {

    private final StockLodzRepository stockLodzRepository;

    public StockLodz save(StockLodz stockLodz) {
        return stockLodzRepository.save(stockLodz);
    }

    public List<StockLodz> findAll() {
        return stockLodzRepository.findAll();
    }

    public StockLodz findStockLodzById(Long id) {
        return stockLodzRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<StockLodz> findStockLodzsBySymbol(String symbol) {
        return stockLodzRepository.findStockLodzsByProductSymbol(symbol);
    }

    public List<StockLodz> findStockLodzsByLocationName(String name) {
        return stockLodzRepository.findStockLodzsByLocationName(name);
    }

    public boolean deleteBy(Long id) {
        stockLodzRepository.deleteById(id);
        return true;
    }
}
