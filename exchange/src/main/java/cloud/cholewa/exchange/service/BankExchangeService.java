package cloud.cholewa.exchange.service;

import cloud.cholewa.exchange.client.ExchangeClient;
import cloud.cholewa.exchange.dto.ExchangeRateResponse;
import cloud.cholewa.exchange.model.Rate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static cloud.cholewa.exchange.utils.DateTimeUtils.getCurrentDateInISO;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankExchangeService implements ExchangeService {

    private final ExchangeClient exchangeClient;
    private final ExchangeConverter exchangeConverter;

    @Override
    public List<Rate> getAllRates() {
        return exchangeClient.getForAllRates().getRates();
    }

    @Override
    public ExchangeRateResponse getConvertedCurrencyByDate(String sourceCurrency, Double sourceValue, String targetCurrency, String date) {
        String queryDate = date != null ? date : getCurrentDateInISO();

        List<Rate> ratesByDate = exchangeClient.getForAllRatesByDate(queryDate).getRates();

        return ExchangeRateResponse.builder()
                .date(queryDate)
                .sourceCurrency(exchangeConverter.getCurrencyCode(ratesByDate, sourceCurrency))
                .sourceAmountOfMoney(sourceValue)
                .targetCurrency(exchangeConverter.getCurrencyCode(ratesByDate, targetCurrency))
                .targetAmountOfMoney(exchangeConverter.calculateExchangeResult(
                        ratesByDate,
                        sourceCurrency,
                        sourceValue,
                        targetCurrency
                ))
                .build();
    }
}
