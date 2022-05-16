package pl.zapas.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.stock.StockLodz;

public interface StockLodzRepository extends JpaRepository<StockLodz, Long> {

}
