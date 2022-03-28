package cloud.cholewa.exchange.service;

import cloud.cholewa.exchange.model.RatesTable;

import java.io.Writer;

public interface ExportService {

    void writeRatesToFile(Writer writer, RatesTable ratesTable);
}
