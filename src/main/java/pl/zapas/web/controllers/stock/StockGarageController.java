package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.dtos.stock.StockDto;
import pl.zapas.dtos.stock.StockDtoWithID;
import pl.zapas.entity.stock.StockGarage;
import pl.zapas.service.stock.StockGarageService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/garage")
public class StockGarageController {

    private final StockGarageService stockGarageService;

    @PostMapping("/add")
    public ResponseEntity<StockGarage> saveStockGarage(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stockGarageService.saveStockGarage(stockDto));
    }

    @GetMapping
    public ResponseEntity<List<StockDtoWithID>> findAllStockGarage() {
        return ResponseEntity.ok(stockGarageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> findStockGarageById(@PathVariable Long id) {
        return ResponseEntity.ok(stockGarageService.findStockGarageById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockDto>> findStockGarageBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockGarageService.findStockGarageBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockDto>> findStockGarageByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockGarageService.findStockGaragesByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockGarage(@PathVariable Long id) {
        return ResponseEntity.ok(stockGarageService.deleteById(id));
    }
}
