package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.stock.StockWarehouse;
import pl.zapas.repository.stock.StockWarehouseRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StockWareHouseService {

    private final StockWarehouseRepository stockWarehouseRepository;

    public StockWarehouse save(StockWarehouse stockWarehouse) {
        return stockWarehouseRepository.save(stockWarehouse);
    }

    public List<StockWarehouse> findAll() {
        return stockWarehouseRepository.findAll();
    }

    public StockWarehouse findStockWarehouseById(Long id) {
        return stockWarehouseRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<StockWarehouse> findStockStockWarehouseBySymbol(String symbol) {
        return stockWarehouseRepository.findStockWarehousesByProductSymbol(symbol);
    }

    public List<StockWarehouse> findStockWarehouseByLocationName(String name) {
        return stockWarehouseRepository.findStockWarehousesByLocationName(name);
    }

    public boolean deleteById(Long id) {
        stockWarehouseRepository.deleteById(id);
        return true;
    }
}
