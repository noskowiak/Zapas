package pl.zapas.repository.primary.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.primary.stock.StockAuction;

import java.util.List;

public interface StockAuctionRepository extends JpaRepository<StockAuction, Long> {

    List<StockAuction> findStockAuctionsByProductSymbol(String symbol);

    List<StockAuction> findStockAuctionsByLocationName(String name);



}
