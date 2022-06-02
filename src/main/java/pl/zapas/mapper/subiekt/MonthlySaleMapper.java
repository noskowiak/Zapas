package pl.zapas.mapper.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.entity.subiekt.MonthlySale;
import pl.zapas.service.subiekt.ProductService;

@Component
@RequiredArgsConstructor
public class MonthlySaleMapper {

    private final ProductService productService;

    public MonthlySaleDto toDto(MonthlySale monthlySale) {
        return new MonthlySaleDto(
                monthlySale.getProduct().getSymbol(),
                monthlySale.getProduct().getName(),
                monthlySale.getSale30Days()
        );
    }

    public MonthlySale toEntity(MonthlySaleDto monthlySaleDto) {
        return new MonthlySale(
                monthlySaleDto.getSale30Days(),
                productService.loadProductBySymbol(monthlySaleDto.getSymbol())

        );

    }
}
