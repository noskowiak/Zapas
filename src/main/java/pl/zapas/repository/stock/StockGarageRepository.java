package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockGarage;

import java.util.List;

public interface StockGarageRepository extends JpaRepository<StockGarage, Long> {

    List<StockGarage> findStockGaragesByProductSymbol(String symbol);

    List<StockGarage> findStockGaragesByLocationName(String name);

}
