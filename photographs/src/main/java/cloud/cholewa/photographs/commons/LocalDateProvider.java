package cloud.cholewa.photographs.commons;

import cloud.cholewa.photographs.ports.DateProvider;

import java.time.LocalDate;

public class LocalDateProvider implements DateProvider {

    public LocalDate getDate() {
        return LocalDate.now();
    }
}
