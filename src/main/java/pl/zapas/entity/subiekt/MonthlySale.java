package pl.zapas.entity.subiekt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MonthlySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sale30Days;

    @OneToOne
    private Product product;


    public MonthlySale(Long sale30Days, Product product) {
        this.sale30Days = sale30Days;
        this.product = product;
    }
}
