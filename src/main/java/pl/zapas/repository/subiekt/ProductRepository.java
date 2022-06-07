package pl.zapas.repository.subiekt;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.dtos.subiekt.ProductDto;
import pl.zapas.entity.subiekt.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findProductBySymbol(String symbol);
}
