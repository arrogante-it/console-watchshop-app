package com.watch.shop.app.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputHandlerTest {
    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @Test
    void shouldCorrectlyReturnEnteredString() {
        String expected = "message";

        InputStream inputStream = new ByteArrayInputStream(expected.getBytes());
        System.setIn(inputStream);

        inputHandler.getUserInput();

        String actual = inputStream.toString();

        assertEquals(expected, actual);
    }
}