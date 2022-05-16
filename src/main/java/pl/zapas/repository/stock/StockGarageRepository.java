package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockGarage;

public interface StockGarageRepository extends JpaRepository<StockGarage, Long> {

}
