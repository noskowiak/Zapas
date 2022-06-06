package pl.zapas.mapper.subiekt;


import org.springframework.stereotype.Component;
import pl.zapas.dtos.subiekt.ProductDto;
import pl.zapas.entity.subiekt.Product;

@Component
public class ProductMapper {

    public Product toEntity (ProductDto productDto) {

        return new Product(productDto.getSymbol(),productDto.getName());
    }
}
