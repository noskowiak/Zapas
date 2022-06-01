package pl.zapas.web.clientControllers.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.service.subiekt.MonthlySaleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monthly-sale")
public class MonthlySaleClientController {

    private final MonthlySaleService monthlySaleService;


    @GetMapping
    public ResponseEntity<List<MonthlySaleDto>> getAllMonthlySale() {return ResponseEntity.ok(monthlySaleService.findAll());}


    @GetMapping("/{symbol}")
    public ResponseEntity<MonthlySaleDto> getMonthlySaleBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(monthlySaleService.loadMonthlyBySymbol(symbol));
    }


}
