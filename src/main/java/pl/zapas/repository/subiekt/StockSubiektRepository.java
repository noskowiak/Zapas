package pl.zapas.repository.subiekt;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.subiekt.StockSubiekt;

public interface StockSubiektRepository extends JpaRepository<StockSubiekt, String> {

    StockSubiekt findStockSubiektByProductSymbol(String symbol);
}
