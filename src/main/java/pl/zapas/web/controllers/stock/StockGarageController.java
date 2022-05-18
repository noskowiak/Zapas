package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.entity.stock.StockGarage;
import pl.zapas.repository.stock.StockGarageRepository;
import pl.zapas.service.stock.StockGarageService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/garage")
public class StockGarageController {

    private final StockGarageService stockGarageService;

    @PostMapping("/add")
    public ResponseEntity<StockGarage> saveStockGarage(StockGarage stockGarage) {
        return ResponseEntity.ok(stockGarageService.save(stockGarage));
    }

    @GetMapping
    public ResponseEntity<List<StockGarage>> findAllStockGarage() {
        return ResponseEntity.ok(stockGarageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockGarage> findStockGarageById(@PathVariable Long id) {
        return ResponseEntity.ok(stockGarageService.findStockGarageById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockGarage>> findStockGarageBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockGarageService.findStockGarageBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockGarage>> findStockGarageByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockGarageService.findStockGaragesByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockGarage(@PathVariable Long id) {
        return ResponseEntity.ok(stockGarageService.deleteBy(id));
    }
}
