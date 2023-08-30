package com.watch.shop.app.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputUtils {
    public static BigDecimal parseToBigDecimal(String value) {
        return BigDecimal.valueOf(Long.parseLong(value));
    }

    public static LocalDate parseToLocalDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(value, formatter);
    }
}
