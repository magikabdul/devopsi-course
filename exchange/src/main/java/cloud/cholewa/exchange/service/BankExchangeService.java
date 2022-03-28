package cloud.cholewa.exchange.service;

import cloud.cholewa.exchange.client.ExchangeClient;
import cloud.cholewa.exchange.dto.ExchangeRateResponse;
import cloud.cholewa.exchange.model.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankExchangeService implements ExchangeService {

    private final ExchangeClient exchangeClient;
    private final ExchangeConverter exchangeConverter;

    @Override
    public List<Rate> getAllRates() {
        return exchangeClient.getForAllRates().getRates();
    }

    @Override
    public ExchangeRateResponse getConvertedCurrencyByDate(String sourceCurrency, Double sourceValue, String targetCurrency) {
        List<Rate> ratesByDate = exchangeClient.getForAllRatesByDate("2022-03-28").getRates();

        return ExchangeRateResponse.builder()
                .sourceCurrency(exchangeConverter.getCurrencyCode(ratesByDate, sourceCurrency))
                .sourceAmountOfMoney(sourceValue)
                .targetCurrency(exchangeConverter.getCurrencyCode(ratesByDate, targetCurrency))
                .targetAmountOfMoney(exchangeConverter.calculateExchangeResult(ratesByDate, sourceCurrency, sourceValue, targetCurrency))
                .build();
    }






}
