package cloud.cholewa.exchange.service;

import cloud.cholewa.exchange.model.RatesTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;

@Service
@Slf4j
public class CsvExportService implements ExportService {


    @Override
    public void writeRatesToFile(Writer writer, RatesTable ratesTable) {

        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            ratesTable.getRates().forEach((rate) -> {
                        try {
                            csvPrinter.printRecord(
                                    rate.getCurrency(),
                                    rate.getCode(),
                                    rate.getMid()
                            );
                        } catch (IOException e) {
                            log.error("csvPrinter.printRecord()");
                            e.printStackTrace();
                        }
                    }

            );
        } catch (IOException e) {
            log.error("new CSVPrinter(writer, CSVFormat.EXCEL)");
            e.printStackTrace();
        }
    }
}
