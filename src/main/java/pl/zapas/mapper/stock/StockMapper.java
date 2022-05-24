package pl.zapas.mapper.stock;

import org.springframework.stereotype.Component;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.Location;
import pl.zapas.entity.stock.*;
import pl.zapas.entity.subiekt.Product;

@Component
public class StockMapper {

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

}
