package pl.zapas.dtos.subiekt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class StockSubiektDto {

    private String symbol;
    private String name;
    private Long stock;

}
