package pl.zapas.mapper.subiekt;

import org.springframework.stereotype.Component;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.entity.subiekt.MonthlySale;

@Component
public class MonthlySaleMapper {
    public MonthlySaleDto toDto(MonthlySale monthlySale) {
         return new MonthlySaleDto(
                 monthlySale.getProduct().getSymbol(),
                 monthlySale.getProduct().getName(),
                 monthlySale.getSale30Days()
         );
    }
}
