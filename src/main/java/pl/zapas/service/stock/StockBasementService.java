package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.dtos.stock.StockDtoWithID;
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

    public StockBasement saveStockBasement(StockDto stockDto) {

        return stockBasementRepository.save(stockMapper.toEntityStockBasement(stockDto));
    }

    public List<StockDtoWithID> findAll() {
       return stockBasementRepository.findAll()
               .stream()
               .map(stockBasement -> new StockDtoWithID(
                       stockBasement.getId(),
                       stockBasement.getProduct().getSymbol(),
                       stockBasement.getProduct().getName(),
                       stockBasement.getQuantity(),
                       stockBasement.getLocation().getName()
               ))
                .collect(Collectors.toList());

        /* return stockBasementRepository.findAll()
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());*/
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

    public boolean deleteById(Long id) {
        stockBasementRepository.deleteById(id);
        return true;
    }
}
