package cloud.cholewa.exchange.service;

import cloud.cholewa.exchange.exception.CurrencyException;
import cloud.cholewa.exchange.model.Rate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class ExchangeConverter {

    private final static String POLISH_CURRENCY_CODE = "PLN";

    public String getCurrencyCode(List<Rate> rates, String currencyCode) {
        List<String> codesList = rates.stream().map(Rate::getCode).toList();

        if (currencyCode.equals(POLISH_CURRENCY_CODE)) {
            return POLISH_CURRENCY_CODE;
        } else if (codesList.contains(currencyCode)) {
            return currencyCode;
        } else {
            throw new CurrencyException("Currency code not found");
        }
    }

    public double calculateExchangeResult(List<Rate> rates, String srcCur, Double srcValue, String tarCur) {
        double v = getCurrencyValue(rates, srcCur) * srcValue;

        return BigDecimal.valueOf(v / getCurrencyValue(rates, tarCur))
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /*
        API of NBP returns all values in relation to the Polish zloty
    */
    private double getCurrencyValue(List<Rate> rates, String currencyCode) {
        if (currencyCode.equals(POLISH_CURRENCY_CODE)) {
            return 1;
        }

        return rates.stream().
                filter(rate -> rate.getCode().equals(currencyCode))
                .findFirst()
                .map(Rate::getMid)
                .orElseThrow(() -> new CurrencyException("Currency code not found"));
    }
}
