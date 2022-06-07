package pl.zapas.mapper.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.*;
import pl.zapas.service.LocationService;
import pl.zapas.service.subiekt.ProductService;


@Component
@RequiredArgsConstructor
public class StockMapper {

    private final ProductService productService;
    private final LocationService locationService;

    public StockDto toDto(StockAuction stockAuction) {

         return new StockDto(
                 stockAuction.getProduct().getSymbol(),
                 stockAuction.getProduct().getName(),
                 stockAuction.getQuantity(),
                 stockAuction.getLocation().getName()
         );
    }


    public StockDto toDto(StockBasement stockBasement) {

        return new StockDto(
                stockBasement.getProduct().getSymbol(),
                stockBasement.getProduct().getName(),
                stockBasement.getQuantity(),
                stockBasement.getLocation().getName()
        );
    }

    public StockDto toDto(StockGarage stockGarage) {

        return new StockDto(
                stockGarage.getProduct().getSymbol(),
                stockGarage.getProduct().getName(),
                stockGarage.getQuantity(),
                stockGarage.getLocation().getName()
        );
    }


    public StockDto toDto(StockLodz stockLodz) {

        return new StockDto(
                stockLodz.getProduct().getSymbol(),
                stockLodz.getProduct().getName(),
                stockLodz.getQuantity(),
                stockLodz.getLocation().getName()
        );
    }

    public StockDto toDto(StockWarehouse stockWarehouse) {

        return new StockDto(
                stockWarehouse.getProduct().getSymbol(),
                stockWarehouse.getProduct().getName(),
                stockWarehouse.getQuantity(),
                stockWarehouse.getLocation().getName()
        );
    }

    public StockAuction toEntityStockAuction(StockDto stockDto) {

        return new StockAuction(
                stockDto.getQuantity(),
                productService.loadProductBySymbol(stockDto.getProductSymbol()),
                locationService.findLocationByName(stockDto.getLocationName())
        );
    }

    public StockBasement toEntityStockBasement(StockDto stockDto) {

        return new StockBasement(
                stockDto.getQuantity(),
                productService.loadProductBySymbol(stockDto.getProductSymbol()),
                locationService.findLocationByName(stockDto.getLocationName())
        );
    }


    public StockGarage toEntityStockGarage(StockDto stockDto) {

        return new StockGarage(
                stockDto.getQuantity(),
                productService.loadProductBySymbol(stockDto.getProductSymbol()),
                locationService.findLocationByName(stockDto.getLocationName())
        );
    }

    public StockLodz toEntityStockLodz(StockDto stockDto) {

        return new StockLodz(
                stockDto.getQuantity(),
                productService.loadProductBySymbol(stockDto.getProductSymbol()),
                locationService.findLocationByName(stockDto.getLocationName())
        );
    }

    public StockWarehouse toEntityStockWarehouse(StockDto stockDto) {

        return new StockWarehouse(
                stockDto.getQuantity(),
                productService.loadProductBySymbol(stockDto.getProductSymbol()),
                locationService.findLocationByName(stockDto.getLocationName())
        );
    }

}
