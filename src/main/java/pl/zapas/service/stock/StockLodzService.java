package pl.zapas.service.stock;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockLodz;
import pl.zapas.mapper.stock.StockMapper;
import pl.zapas.repository.stock.StockLodzRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockLodzService {

    private final StockLodzRepository stockLodzRepository;
    private final StockMapper stockMapper;

    public StockLodz save(StockDto stockDto) {
        return stockLodzRepository.save(stockMapper.toEntityStockLodz(stockDto));
    }

    public List<StockDto> findAll() {
        return stockLodzRepository.findAll()
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public StockDto findStockLodzById(Long id) {
        return stockMapper.toDto(stockLodzRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<StockDto> findStockLodzsBySymbol(String symbol) {
        return stockLodzRepository.findStockLodzsByProductSymbol(symbol)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }


    public List<StockDto> findStockLodzsByLocationName(String name) {
        return stockLodzRepository.findStockLodzsByLocationName(name)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }


    public boolean deleteBy(Long id) {
        stockLodzRepository.deleteById(id);
        return true;
    }
}
