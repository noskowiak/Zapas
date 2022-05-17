package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockLodz;

import java.util.List;

public interface StockLodzRepository extends JpaRepository<StockLodz, Long> {

    List<StockLodz> findStockLodzsByProductSymbol(String symbol);

    List<StockLodz> findStockLodzsByLocationName(String name);

}
