package com.watch.shop.app.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHandler {
    public Object inputData() {
        String inputValue = new Scanner(System.in).nextLine();

        if (isNumeric(inputValue)) {
            return parseToBigDecimal(inputValue);
        } else if (isDate(inputValue)) {
            return parseToLocalDate(inputValue);
        } else {
            return inputValue;
        }
    }

    private static boolean isNumeric(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(value, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static BigDecimal parseToBigDecimal(String value) {
        return BigDecimal.valueOf(Long.parseLong(value));
    }

    private LocalDate parseToLocalDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return LocalDate.parse(value, formatter);
    }
}
