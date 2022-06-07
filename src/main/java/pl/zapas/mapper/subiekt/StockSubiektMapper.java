package pl.zapas.mapper.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zapas.dtos.subiekt.StockSubiektDto;
import pl.zapas.entity.subiekt.StockSubiekt;
import pl.zapas.service.subiekt.ProductService;

@Component
@RequiredArgsConstructor
public class StockSubiektMapper {
    private final ProductService productService;

    public StockSubiektDto toDto(StockSubiekt stockSubiekt) {
        return new StockSubiektDto(
                stockSubiekt.getProduct().getSymbol(),
                stockSubiekt.getProduct().getName(),
                stockSubiekt.getStock()
        );
    }

    public StockSubiekt toEntity(StockSubiektDto stockSubiektDto) {
        return new StockSubiekt(
                stockSubiektDto.getStock(),
                productService.loadProductBySymbol(stockSubiektDto.getSymbol())
        );
    }
}
