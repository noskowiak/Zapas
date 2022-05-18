package pl.zapas.repository.subiekt;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.subiekt.MonthlySale;
import pl.zapas.entity.subiekt.Product;
import java.util.List;
import java.util.Optional;

public interface MonthlySaleRepository extends JpaRepository<MonthlySale, String> {
   // Optional<Product> findProductBySymbol(String symbol);

    MonthlySale findMonthlySaleByProductSymbol(String Symbol);

}
