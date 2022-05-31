package pl.zapas.repository.primary.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.primary.stock.StockWarehouse;

import java.util.List;

public interface StockWarehouseRepository extends JpaRepository<StockWarehouse, Long> {

    List<StockWarehouse> findStockWarehousesByProductSymbol(String symbol);

    List<StockWarehouse> findStockWarehousesByLocationName(String name);
}
