package pl.zapas.dtos.subiekt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlySaleDto {
    private String symbol;
    private String name;
    private Long sale30Days;

}
