package cloud.cholewa.exchange.client;

import cloud.cholewa.exchange.model.RatesTable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ExchangeClient {

    private final static String EXCHANGE_URL = "http://api.nbp.pl/api/exchangerates";

    private final RestTemplate restTemplate = new RestTemplate();

    public RatesTable getForAllRates() {
        RatesTable[] forObject = restTemplate.getForObject(EXCHANGE_URL + "/tables/A", RatesTable[].class);

        return Arrays.stream(forObject).findFirst().orElseThrow();
    }

    public RatesTable getForAllRatesByDate(String date) {
        String URL = EXCHANGE_URL + "/tables/A/" + date;

        RatesTable[] forObject = restTemplate.getForObject(URL, RatesTable[].class);

        return Arrays.stream(forObject).findFirst().orElseThrow();
    }
}
