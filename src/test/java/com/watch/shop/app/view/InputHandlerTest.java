package com.watch.shop.app.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputHandlerTest {
    private static final String EXPECTED_MESSAGE = "message";
    private static final String EXCEPTION_MESSAGE = "stream not closed";

    @Test
    void shouldCorrectlyReturnEnteredString() {
        InputStream originalSystemIn = System.in;

        try {
            InputStream inputStream = new ByteArrayInputStream(EXPECTED_MESSAGE.getBytes());
            System.setIn(inputStream);

            InputHandler inputHandler = new InputHandler(System.in);
            String actual = inputHandler.getUserInput();

            inputStream.close();

            assertEquals(EXPECTED_MESSAGE, actual);

        } catch (Exception e) {
            fail(EXCEPTION_MESSAGE, e);
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}