package com.watch.shop.app.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public String nextLine() {
        return InputHandler.scanner.nextLine();
    }

    public <T> T inputData(Class<T> clazz) {
        String inputValue = nextLine();

        if (clazz == BigDecimal.class && InputUtils.isNumeric(inputValue)) {
            return clazz.cast(InputUtils.parseToBigDecimal(inputValue));
        } else if (clazz == LocalDate.class && InputUtils.isDate(inputValue)) {
            return clazz.cast(InputUtils.parseToLocalDate(inputValue));
        } else {
            return clazz.cast(inputValue);
        }
    }
}
