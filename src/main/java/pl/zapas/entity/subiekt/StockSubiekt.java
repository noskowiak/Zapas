package pl.zapas.entity.subiekt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StockSubiekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stock;

    @OneToOne
    private Product product;

    public StockSubiekt(Long stock, Product product) {
        this.stock = stock;
        this.product = product;
    }
}
