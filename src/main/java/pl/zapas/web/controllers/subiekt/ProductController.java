package pl.zapas.web.controllers.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.dtos.subiekt.ProductDto;
import pl.zapas.entity.subiekt.Product;
import pl.zapas.service.subiekt.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

private  final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> gatAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Product> getProductBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(productService.loadProductBySymbol(symbol));
    }

    @GetMapping("/saveProduct")
    public ResponseEntity<ProductDto[]> saveProduct() {

        return ResponseEntity.ok(productService.save());
    }
}
