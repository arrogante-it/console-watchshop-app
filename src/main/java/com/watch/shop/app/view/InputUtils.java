package com.watch.shop.app.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputUtils {
    public static BigDecimal parseToBigDecimal(String value) {
        return BigDecimal.valueOf(Long.parseLong(value));
    }

    public static LocalDate parseToLocalDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return LocalDate.parse(value, formatter);
    }
}
