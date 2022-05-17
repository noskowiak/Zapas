package pl.zapas.service.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.stock.StockAuction;
import pl.zapas.repository.stock.StockAuctionRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StockAuctionService {

    private final StockAuctionRepository stockAuctionRepository;

    public StockAuction save(StockAuction stockAuction) {
        return stockAuctionRepository.save(stockAuction);
    }

    public List<StockAuction> findAll() {
        return stockAuctionRepository.findAll();
    }

    public StockAuction findStockAuctionById(Long id) {
        return stockAuctionRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<StockAuction> findStockAuctionsBySymbol(String symbol) {
        return stockAuctionRepository.findStockAuctionsByProductSymbol(symbol);
    }

    public List<StockAuction> findStockAuctionsByLocationName(String name) {
        return stockAuctionRepository.findStockAuctionsByLocationName(name);
    }

    public boolean deleteBy(Long id) {
        stockAuctionRepository.deleteById(id);
        return true;
    }
}
