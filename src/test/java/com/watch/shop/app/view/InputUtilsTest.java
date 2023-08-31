package com.watch.shop.app.view;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class InputUtilsTest {
    @Test
    void shouldCorrectlyParseToBigDecimal() {
        BigDecimal actual = InputUtils.parseToBigDecimal("10");
        BigDecimal expected = BigDecimal.valueOf(10);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyParseToLocalDate() {
        LocalDate actual = InputUtils.parseToLocalDate("2023-08-31");
        LocalDate expected = LocalDate.of(2023, 8, 31);

        assertEquals(expected, actual);
    }
}