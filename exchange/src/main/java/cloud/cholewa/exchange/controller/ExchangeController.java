package cloud.cholewa.exchange.controller;

import cloud.cholewa.exchange.dto.ExchangeRateResponse;
import cloud.cholewa.exchange.model.Rate;
import cloud.cholewa.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        return ResponseEntity.ok(exchangeService.getAllRates());
    }

    @GetMapping("/convert")
    public ResponseEntity<ExchangeRateResponse> convertCurrency(
            @RequestParam String sourceCurrency,
            @RequestParam Double sourceValue,
            @RequestParam String targetCurrency) {
        return ResponseEntity.ok(exchangeService.getConvertedCurrencyByDate(sourceCurrency, sourceValue, targetCurrency));
    }
}
