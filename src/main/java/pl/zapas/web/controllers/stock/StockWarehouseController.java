package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.entity.stock.StockWarehouse;
import pl.zapas.service.stock.StockWarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/warehouse")
public class StockWarehouseController {

    private final StockWarehouseService stockWarehouseService;

    @PostMapping("/add")
    public ResponseEntity<StockWarehouse> saveStockWarehouse(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stockWarehouseService.save(stockDto));
    }

    @GetMapping
    public ResponseEntity<List<StockDto>> findAllStockWarehouse() {
        return ResponseEntity.ok(stockWarehouseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> findStockWarehouseById(@PathVariable Long id) {
        return ResponseEntity.ok(stockWarehouseService.findStockWarehouseById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockDto>> findStockWarehouseBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockWarehouseService.findStockStockWarehouseBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockDto>> findStockWarehouseByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockWarehouseService.findStockWarehouseByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockWarehouse(@PathVariable Long id) {
        return ResponseEntity.ok(stockWarehouseService.deleteById(id));
    }
}
