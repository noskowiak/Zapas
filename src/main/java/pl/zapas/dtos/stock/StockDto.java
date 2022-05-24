package pl.zapas.dtos.stock;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StockDto {

    private String productSymbol;
    private String productName;
    private Long quantity;
    private String locationName;
}
