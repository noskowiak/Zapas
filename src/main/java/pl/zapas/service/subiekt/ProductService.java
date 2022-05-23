package pl.zapas.service.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.dtos.subiekt.ProductDto;
import pl.zapas.entity.subiekt.Product;
import pl.zapas.repository.subiekt.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDto(
                        product.getName(),
                        product.getSymbol()))
                .collect(Collectors.toList());
    }

    public Product loadProductBySymbol(final String symbol) {
        return productRepository.findProductBySymbol(symbol);
    }

}
