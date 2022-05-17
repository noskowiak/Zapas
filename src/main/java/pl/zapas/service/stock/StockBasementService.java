package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.stock.StockBasement;
import pl.zapas.repository.stock.StockBasementRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StockBasementService {

    private final StockBasementRepository stockBasementRepository;

    public StockBasement save(StockBasement stockBasement) {
        return stockBasementRepository.save(stockBasement);
    }

    public List<StockBasement> findAll() {
        return stockBasementRepository.findAll();
    }

    public StockBasement findStockBasementById(Long id) {
        return stockBasementRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<StockBasement> findStockBasementsBySymbol(String symbol) {
        return stockBasementRepository.findStockBasementsByProductSymbol(symbol);
    }

    public List<StockBasement> findStockBasementsByLocationName(String name) {
        return stockBasementRepository.findStockBasementsByLocationName(name);
    }

    public boolean deleteBy(Long id) {
        stockBasementRepository.deleteById(id);
        return true;
    }
}
