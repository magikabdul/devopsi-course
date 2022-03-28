package cloud.cholewa.exchange.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static String getCurrentDateInISO() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}
