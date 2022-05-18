package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockBasement;

import java.util.List;

public interface StockBasementRepository extends JpaRepository<StockBasement, Long> {
    List<StockBasement> findStockBasementsByProductSymbol (String symbol);
    List<StockBasement> findStockBasementsByLocationName (String name);
}
