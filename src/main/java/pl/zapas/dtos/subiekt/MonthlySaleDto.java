package pl.zapas.dtos.subiekt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MonthlySaleDto {
    private String symbol;
    private String name;
    private Long sale30Days;

}
