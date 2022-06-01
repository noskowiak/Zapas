package pl.zapas.web.clientControllers.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zapas.dtos.subiekt.StockSubiektDto;
import pl.zapas.service.subiekt.StockSubiektService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock-subiekt")
public class StockSubiektClientController {

    private final StockSubiektService stockSubiektService;

    @GetMapping
    public ResponseEntity<List<StockSubiektDto>> gatAllStockSubiekt() {return ResponseEntity.ok(stockSubiektService.findAll());}

    @GetMapping("/{symbol}")
    public ResponseEntity<StockSubiektDto> getStockSubiektBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(stockSubiektService.loadProductBySymbol(symbol));
    }

}
