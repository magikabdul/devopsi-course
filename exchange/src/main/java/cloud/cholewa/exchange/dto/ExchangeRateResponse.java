package cloud.cholewa.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ExchangeRateResponse {

    private String sourceCurrency;
    private double sourceAmountOfMoney;
    private String targetCurrency;
    private double targetAmountOfMoney;
}
