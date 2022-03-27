package cloud.cholewa.exchange.service;

import cloud.cholewa.exchange.client.ExchangeClient;
import cloud.cholewa.exchange.model.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankExchangeService implements ExchangeService {

    private final ExchangeClient exchangeClient;

    @Override
    public List<Rate> getAllRates() {
        return exchangeClient.getForAllRates().getRates();
    }
}
