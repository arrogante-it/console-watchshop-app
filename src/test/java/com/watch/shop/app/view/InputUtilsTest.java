package com.watch.shop.app.view;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class InputUtilsTest {
    private static final Long TEST_VALUE = 10L;

    @Test
    void shouldCorrectlyParseToBigDecimal() {
        BigDecimal expected = BigDecimal.valueOf(TEST_VALUE);
        BigDecimal actual = InputUtils.parseToBigDecimal(TEST_VALUE.toString());
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyParseToLocalDate() {
        LocalDate expected = LocalDate.of(2023, 8, 31);
        LocalDate actual = InputUtils.parseToLocalDate("2023-08-31");
        assertEquals(expected, actual);
    }
}