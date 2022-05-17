package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.stock.StockGarage;
import pl.zapas.repository.stock.StockGarageRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StockGarageService {

    private final StockGarageRepository stockGarageRepository;

    public StockGarage save(StockGarage stockGarage) {
        return stockGarageRepository.save(stockGarage);
    }

    public List<StockGarage> findAll() {
        return stockGarageRepository.findAll();
    }

    public StockGarage findStockGarageById(Long id) {
        return stockGarageRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<StockGarage> findStockGarageBySymbol(String symbol) {
        return stockGarageRepository.findStockGaragesByProductSymbol(symbol);
    }

    public List<StockGarage> findStockGaragesByLocationName(String name) {
        return stockGarageRepository.findStockGaragesByLocationName(name);
    }

    public boolean deleteBy(Long id) {
        stockGarageRepository.deleteById(id);
        return true;
    }
}
