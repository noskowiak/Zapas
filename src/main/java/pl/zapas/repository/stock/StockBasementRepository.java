package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockBasement;

public interface StockBasementRepository extends JpaRepository<StockBasement, Long> {

}
