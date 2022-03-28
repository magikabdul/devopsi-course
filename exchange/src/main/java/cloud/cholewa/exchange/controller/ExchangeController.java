package cloud.cholewa.exchange.controller;

import cloud.cholewa.exchange.dto.ExchangeRateResponse;
import cloud.cholewa.exchange.model.Rate;
import cloud.cholewa.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static cloud.cholewa.exchange.utils.DateTimeUtils.getCurrentDateInISO;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
@Slf4j
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
            @RequestParam String targetCurrency,
            @RequestParam(required = false) String date) {
        return ResponseEntity.ok(exchangeService.getConvertedCurrencyByDate(
                sourceCurrency,
                sourceValue,
                targetCurrency,
                date));
    }

    @GetMapping("/toFile")
    public ResponseEntity<Void> getAllRatesByAndStoreToFile(HttpServletResponse response, @RequestParam(required = false) String date) {
        String queryDate = date != null ? date : getCurrentDateInISO();
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition","attachment; filename=\"" + queryDate + "---rates.csv\"");
        try {
            exchangeService.createCSVFileWithAllRatesByDate(response.getWriter(), date);
        } catch (IOException e) {
            log.error("exchangeService.createCSVFileWithAllRatesByDate(response.getWriter(), date)");
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
