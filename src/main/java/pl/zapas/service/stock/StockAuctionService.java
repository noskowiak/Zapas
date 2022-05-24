package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockAuction;
import pl.zapas.mapper.stock.StockMapper;
import pl.zapas.repository.stock.StockAuctionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockAuctionService {

    private final StockAuctionRepository stockAuctionRepository;
    private final StockMapper stockMapper;

    public StockAuction save(StockAuction stockAuction) {
        return stockAuctionRepository.save(stockAuction);
    }

    public List<StockDto> findAll() {
        return stockAuctionRepository.findAll()
                .stream()
                .map(stockAuction -> new StockDto(
                        stockAuction.getProduct().getSymbol(),
                        stockAuction.getProduct().getName(),
                        stockAuction.getQuantity(),
                        stockAuction.getLocation().getName()
                ))
                .collect(Collectors.toList());
    }

    public StockDto findStockAuctionById(Long id) {
        return stockMapper.toDto(stockAuctionRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<StockDto> findStockAuctionsBySymbol(String symbol) {
        return stockAuctionRepository.findStockAuctionsByProductSymbol(symbol)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());

    }

    public List<StockDto> findStockAuctionsByLocationName(String name) {
        return stockAuctionRepository.findStockAuctionsByLocationName(name)
                .stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

    public boolean deleteBy(Long id) {
        stockAuctionRepository.deleteById(id);
        return true;
    }
}
