package pl.zapas.dtos.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor
public class StockDtoWithID {

    private Long id;
    private String productSymbol;
    private String productName;
    private Long quantity;
    private String locationName;
}
