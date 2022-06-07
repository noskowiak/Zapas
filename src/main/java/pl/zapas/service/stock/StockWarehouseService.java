package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockWarehouse;
import pl.zapas.mapper.stock.StockMapper;
import pl.zapas.repository.stock.StockWarehouseRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockWarehouseService {

    private final StockWarehouseRepository stockWarehouseRepository;
    private final StockMapper stockMapper;

    public StockWarehouse save(StockDto stockDto) {

        return stockWarehouseRepository.save(stockMapper.toEntityStockWarehouse(stockDto));
    }

    public List<StockDto> findAll() {
        return stockWarehouseRepository.findAll()
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());

    }

    public StockDto findStockWarehouseById(Long id) {
        return stockMapper.toDto(stockWarehouseRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<StockDto> findStockStockWarehouseBySymbol(String symbol) {
        return stockWarehouseRepository.findStockWarehousesByProductSymbol(symbol)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<StockDto> findStockWarehouseByLocationName(String name) {
        return stockWarehouseRepository.findStockWarehousesByLocationName(name)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean deleteById(Long id) {
        stockWarehouseRepository.deleteById(id);
        return true;
    }
}
