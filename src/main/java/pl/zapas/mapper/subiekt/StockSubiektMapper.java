package pl.zapas.mapper.subiekt;

import org.springframework.stereotype.Component;
import pl.zapas.dtos.subiekt.StockSubiektDto;
import pl.zapas.entity.subiekt.StockSubiekt;

@Component
public class StockSubiektMapper {
    public StockSubiektDto toDto(StockSubiekt stockSubiekt) {
        return new StockSubiektDto(
                stockSubiekt.getProduct().getSymbol(),
                stockSubiekt.getProduct().getName(),
                stockSubiekt.getStock()
        );
    }
}
