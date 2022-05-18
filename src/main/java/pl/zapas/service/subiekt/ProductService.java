package pl.zapas.service.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.subiekt.Product;
import pl.zapas.repository.subiekt.ProductRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product loadProductBySymbol(final String symbol) {
        return productRepository.findProductBySymbol(symbol);
    }

}
