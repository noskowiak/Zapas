package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockGarage;
import pl.zapas.mapper.stock.StockMapper;
import pl.zapas.repository.stock.StockGarageRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockGarageService {

    private final StockGarageRepository stockGarageRepository;
    private final StockMapper stockMapper;

    public StockGarage saveStockGarage( StockDto stockDto) {

        return stockGarageRepository.save(stockMapper.toEntityStockGarage(stockDto));
    }

    public List<StockDto> findAll() {
        return stockGarageRepository.findAll()
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public StockDto findStockGarageById(Long id) {
        return stockMapper.toDto(stockGarageRepository.findById(id).orElseThrow(NoSuchElementException::new));    }

    public List<StockDto> findStockGarageBySymbol(String symbol) {
        return stockGarageRepository.findStockGaragesByProductSymbol(symbol)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<StockDto> findStockGaragesByLocationName(String name) {
        return stockGarageRepository.findStockGaragesByLocationName(name)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean deleteBy(Long id) {
        stockGarageRepository.deleteById(id);
        return true;
    }
}
