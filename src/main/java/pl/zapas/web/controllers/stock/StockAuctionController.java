package pl.zapas.web.controllers.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.dtos.stock.StockAuctionDto;
import pl.zapas.entity.stock.StockAuction;
import pl.zapas.service.stock.StockAuctionService;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/auction")
public class StockAuctionController {

    private final StockAuctionService stockAuctionService;

    @PostMapping("/add")
    public ResponseEntity<StockAuction> saveStockAuction(@RequestBody StockAuction stockAuction) {
        return ResponseEntity.ok(stockAuctionService.save(stockAuction));
    }

    @GetMapping
    public ResponseEntity<List<StockAuctionDto>> findAllStockAuctions() {
        return ResponseEntity.ok(stockAuctionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockAuction> findStockAuctionById(@PathVariable Long id) {
        return ResponseEntity.ok(stockAuctionService.findStockAuctionById(id));
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<List<StockAuction>> findStockAuctionBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockAuctionService.findStockAuctionsBySymbol(symbol));
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<StockAuction>> findStockAuctionByLocation(@PathVariable String location) {
        return ResponseEntity.ok(stockAuctionService.findStockAuctionsByLocationName(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStockAuction(@PathVariable Long id) {
        return ResponseEntity.ok(stockAuctionService.deleteBy(id));
    }
}
