package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockWarehouse;

import java.util.List;

public interface StockWarehouseRepository extends JpaRepository<StockWarehouse, Long> {

    List<StockWarehouse> findStockWarehousesByProductSymbol(String symbol);

    List<StockWarehouse> findStockWarehousesByLocationName(String name);
}
