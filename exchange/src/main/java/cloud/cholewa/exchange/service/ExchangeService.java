package cloud.cholewa.exchange.service;


import cloud.cholewa.exchange.dto.ExchangeRateResponse;
import cloud.cholewa.exchange.model.Rate;

import java.io.Writer;
import java.util.List;

public interface ExchangeService {

    List<Rate> getAllRates();

    ExchangeRateResponse getConvertedCurrencyByDate(String srcCur, Double srcValue, String tarCur, String date);

    void createCSVFileWithAllRatesByDate(Writer writer, String date);
}
