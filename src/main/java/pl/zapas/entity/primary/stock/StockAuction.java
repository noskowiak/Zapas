package pl.zapas.entity.primary.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zapas.entity.primary.Location;
import pl.zapas.entity.subiekt.Product;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StockAuction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Location location;

}
