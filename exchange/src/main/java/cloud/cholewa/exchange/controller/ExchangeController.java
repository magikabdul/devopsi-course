package cloud.cholewa.exchange.controller;

import cloud.cholewa.exchange.model.Rate;
import cloud.cholewa.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
