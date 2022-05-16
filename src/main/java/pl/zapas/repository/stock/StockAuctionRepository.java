package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockAuction;

import java.util.List;

public interface StockAuctionRepository extends JpaRepository<StockAuction, Long> {

}
