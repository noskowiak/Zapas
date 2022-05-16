package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockWarehouse;

public interface StockWarehouseRepository extends JpaRepository<StockWarehouse, Long> {

}
