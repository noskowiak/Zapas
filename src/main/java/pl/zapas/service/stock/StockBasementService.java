package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockBasement;
import pl.zapas.mapper.stock.StockMapper;
import pl.zapas.repository.stock.StockBasementRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockBasementService {

    private final StockBasementRepository stockBasementRepository;
    private final StockMapper stockMapper;

    public StockBasement save(StockBasement stockBasement) {
        return stockBasementRepository.save(stockBasement);
    }

    public List<StockDto> findAll() {
        return stockBasementRepository.findAll()
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public StockDto findStockBasementById(Long id) {
        return stockMapper.toDto(stockBasementRepository.findById(id).orElseThrow(NoSuchElementException::new));

    }

    public List<StockDto> findStockBasementsBySymbol(String symbol) {
        return stockBasementRepository.findStockBasementsByProductSymbol(symbol)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<StockDto> findStockBasementsByLocationName(String name) {
        return stockBasementRepository.findStockBasementsByLocationName(name)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean deleteBy(Long id) {
        stockBasementRepository.deleteById(id);
        return true;
    }
}
