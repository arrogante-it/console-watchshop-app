package com.watch.shop.app.view;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;
import static com.watch.shop.app.view.Constants.AVAILABLE_WATCHES_MESSAGE;
import static com.watch.shop.app.view.Constants.NEXT_LINE_MESSAGE;
import static com.watch.shop.app.view.Constants.NO_AVAILABLE_WATCHES_MESSAGE;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

class WatchViewTest {
    private final String MESSAGE = "message";

    private WatchView watchView;

    @BeforeEach
    void setUp() {
        watchView = new WatchView();
    }

    @Test
    void shouldCorrectlyShowWatchCollectionWithEmptyList() {
        List<Watch> watches = emptyList();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            watchView.showWatchCollection(watches);

            String actual = outputStream.toString();

            assertEquals(NO_AVAILABLE_WATCHES_MESSAGE, actual);
        } finally {
            System.setOut(new PrintStream(originalSystemOut));
        }
    }

    @Test
    void shouldCorrectlyShowWatchCollectionWithNonEmptyList() {
        List<Watch> watches = buildWatchList();

        String watch1 = watches.get(0).toString();
        String watch2 = watches.get(1).toString();
        String watch3 = watches.get(2).toString();

        String expected = AVAILABLE_WATCHES_MESSAGE +
                NEXT_LINE_MESSAGE +
                watch1 +
                NEXT_LINE_MESSAGE +
                watch2 +
                NEXT_LINE_MESSAGE +
                watch3;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            watchView.showWatchCollection(watches);
            String actual = outputStream.toString();

            assertEquals(expected, actual);
        } finally {
            System.setOut(new PrintStream(originalSystemOut));
        }
    }

    @Test
    void shouldCorrectlyDisplayMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        watchView.displayMessage(MESSAGE);
        String actual = outputStream.toString();

        assertEquals(MESSAGE, actual);
    }

    private List<Watch> buildWatchList() {
        Watch watch1 = new Watch.Builder()
                .arrivalDate(LocalDate.of(2000, 2, 2))
                .type(Type.valueOf("WRIST"))
                .mechanism(Mechanism.valueOf("MECHANICAL"))
                .price(BigDecimal.valueOf(100))
                .color(Color.valueOf("WHITE"))
                .brand(Brand.valueOf("CASIO"))
                .build();

        Watch watch2 = new Watch.Builder()
                .arrivalDate(LocalDate.of(1999, 1, 1))
                .type(Type.valueOf("DESKTOP"))
                .mechanism(Mechanism.valueOf("KINETIC"))
                .price(BigDecimal.valueOf(200))
                .color(Color.valueOf("BLACK"))
                .brand(Brand.valueOf("ARMANI"))
                .build();

        Watch watch3 = new Watch.Builder()
                .arrivalDate(LocalDate.of(2023, 3, 3))
                .type(Type.valueOf("WALL"))
                .mechanism(Mechanism.valueOf("QUARTZ"))
                .price(BigDecimal.valueOf(50))
                .color(Color.valueOf("BLACK"))
                .brand(Brand.valueOf("DW"))
                .build();

        return List.of(watch1, watch2, watch3);
    }
}