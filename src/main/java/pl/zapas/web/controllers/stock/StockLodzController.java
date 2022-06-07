package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockLodz;
import pl.zapas.service.stock.StockLodzService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/lodz")
public class StockLodzController {
    private final StockLodzService stockLodzService;

    @PostMapping("/add")
    public ResponseEntity<StockLodz> saveStockLodz(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stockLodzService.save(stockDto));
    }

    @GetMapping
    public ResponseEntity<List<StockDto>> findAllStockLodz() {
        return ResponseEntity.ok(stockLodzService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> findStockLodzById(@PathVariable Long id) {
        return ResponseEntity.ok(stockLodzService.findStockLodzById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockDto>> findStockLodzBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockLodzService.findStockLodzsBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockDto>> findStockLodzByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockLodzService.findStockLodzsByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockLodz(@PathVariable Long id) {
        return ResponseEntity.ok(stockLodzService.deleteBy(id));
    }
}
