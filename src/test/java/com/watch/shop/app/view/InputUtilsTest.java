package com.watch.shop.app.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class InputUtilsTest {
    private static final Long NUMBER = 10L;
    private static final LocalDate DATE = LocalDate.parse("2023-08-31");

    @Test
    void shouldCorrectlyParseToBigDecimal() {
        BigDecimal expected = BigDecimal.valueOf(NUMBER);
        BigDecimal actual = InputUtils.parseToBigDecimal(NUMBER.toString());
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyParseToLocalDate() {
        LocalDate expected = DATE;
        LocalDate actual = InputUtils.parseToLocalDate(DATE.toString());
        assertEquals(expected, actual);
    }
}