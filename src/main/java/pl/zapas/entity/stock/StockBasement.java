package pl.zapas.entity.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zapas.entity.Location;
import pl.zapas.entity.subiekt.Product;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StockBasement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Location location;

    public StockBasement(Long quantity, Product product, Location location) {
        this.quantity = quantity;
        this.product = product;
        this.location = location;
    }
}
