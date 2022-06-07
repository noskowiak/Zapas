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
public class StockAuction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    @ManyToOne(targetEntity=Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(targetEntity=Location.class)
    @JoinColumn(name = "location_id")
    private Location location;

    public StockAuction(Long quantity, Product product, Location location) {
        this.quantity = quantity;
        this.product = product;
        this.location = location;
    }
}
