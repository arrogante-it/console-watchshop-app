package com.watch.shop.app.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class InputHandlerTest {
    private static final String EXPECTED_MESSAGE = "message";

    @Test
    void shouldCorrectlyReturnEnteredString() {
        InputStream originalSystemIn = System.in;
        try {
            InputStream inputStream = new ByteArrayInputStream(EXPECTED_MESSAGE.getBytes());
            System.setIn(inputStream);

            Scanner scanner = new Scanner(System.in);
            String actual = scanner.nextLine();

            inputStream.close();

            assertEquals(EXPECTED_MESSAGE, actual);
        } catch (Exception e) {
            fail("stream not closed", e);
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}