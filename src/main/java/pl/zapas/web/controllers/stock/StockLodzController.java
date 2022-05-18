package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.entity.stock.StockLodz;
import pl.zapas.service.stock.StockLodzService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/lodz")
public class StockLodzController {
    private final StockLodzService stockLodzService;

    @PostMapping("/add")
    public ResponseEntity<StockLodz> saveStockLodz(StockLodz stockLodz) {
        return ResponseEntity.ok(stockLodzService.save(stockLodz));
    }

    @GetMapping
    public ResponseEntity<List<StockLodz>> findAllStockLodz() {
        return ResponseEntity.ok(stockLodzService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockLodz> findStockLodzById(@PathVariable Long id) {
        return ResponseEntity.ok(stockLodzService.findStockLodzById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockLodz>> findStockLodzBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockLodzService.findStockLodzsBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockLodz>> findStockLodzByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockLodzService.findStockLodzsByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockLodz(@PathVariable Long id) {
        return ResponseEntity.ok(stockLodzService.deleteBy(id));
    }
}
