package pl.zapas.web.controllers.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zapas.entity.subiekt.MonthlySale;
import pl.zapas.service.subiekt.MonthlySaleService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monthly-sale")
public class MonthlySaleController {

    private final MonthlySaleService monthlySaleService;


    @GetMapping
    public ResponseEntity<List<MonthlySale>> getAllMonthlySale() {return ResponseEntity.ok(monthlySaleService.findAll());}


    @GetMapping("/{symbol}")
    public ResponseEntity<MonthlySale> getMonthlySaleBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(monthlySaleService.loadMonthlyBySymbol(symbol));
    }


}
