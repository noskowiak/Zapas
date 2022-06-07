package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.dtos.stock.StockDtoWithID;
import pl.zapas.entity.stock.StockBasement;
import pl.zapas.service.stock.StockBasementService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/basement")
public class StockBasementController {

    private final StockBasementService stockBasementService;

    @PostMapping("/add")
    public ResponseEntity<StockBasement> saveStockBasement(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stockBasementService.saveStockBasement(stockDto));
    }

    @GetMapping
    public ResponseEntity<List<StockDtoWithID>> findAllStockBasement() {
        return ResponseEntity.ok(stockBasementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> findStockBasementById(@PathVariable Long id) {
        return ResponseEntity.ok(stockBasementService.findStockBasementById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockDto>> findStockBasementBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockBasementService.findStockBasementsBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockDto>> findStockBasementByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockBasementService.findStockBasementsByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockBasement(@PathVariable Long id) {
        return ResponseEntity.ok(stockBasementService.deleteById(id));
    }
}

