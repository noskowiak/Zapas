package pl.zapas.repository.subiekt;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.subiekt.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findProductBySymbol(String symbol);
}
