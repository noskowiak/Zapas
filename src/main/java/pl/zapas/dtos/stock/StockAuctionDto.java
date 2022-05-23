package pl.zapas.dtos.stock;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StockAuctionDto {

    private Long quantity;
    private String productSymbol;
    private String productName;
    private String locationName;
}
