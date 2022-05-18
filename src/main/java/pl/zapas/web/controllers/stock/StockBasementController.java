package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.entity.stock.StockBasement;
import pl.zapas.service.stock.StockBasementService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/basement")
public class StockBasementController {

    private final StockBasementService stockBasementService;

    @PostMapping("/add")
    public ResponseEntity<StockBasement> saveStockBasement(StockBasement stockBasement) {
        return ResponseEntity.ok(stockBasementService.save(stockBasement));
    }

    @GetMapping
    public ResponseEntity<List<StockBasement>> findAllStockBasement() {
        return ResponseEntity.ok(stockBasementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockBasement> findStockBasementById(@PathVariable Long id) {
        return ResponseEntity.ok(stockBasementService.findStockBasementById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockBasement>> findStockBasementBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockBasementService.findStockBasementsBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockBasement>> findStockBasementByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockBasementService.findStockBasementsByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockBasement(@PathVariable Long id) {
        return ResponseEntity.ok(stockBasementService.deleteBy(id));
    }
}

