package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.entity.stock.StockWarehouse;
import pl.zapas.service.stock.StockWarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/warehouse")
public class StockWarehouseController {

    private final StockWarehouseService stockWarehouseService;

    @PostMapping("/add")
    public ResponseEntity<StockWarehouse> saveStockWarehouse(StockWarehouse stockWarehouse) {
        return ResponseEntity.ok(stockWarehouseService.save(stockWarehouse));
    }

    @GetMapping
    public ResponseEntity<List<StockWarehouse>> findAllStockWarehouse() {
        return ResponseEntity.ok(stockWarehouseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockWarehouse> findStockWarehouseById(@PathVariable Long id) {
        return ResponseEntity.ok(stockWarehouseService.findStockWarehouseById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockWarehouse>> findStockWarehouseBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockWarehouseService.findStockStockWarehouseBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockWarehouse>> findStockWarehouseByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockWarehouseService.findStockWarehouseByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockWarehouse(@PathVariable Long id) {
        return ResponseEntity.ok(stockWarehouseService.deleteById(id));
    }
}