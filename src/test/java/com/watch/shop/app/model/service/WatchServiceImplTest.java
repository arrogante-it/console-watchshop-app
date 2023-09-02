package com.watch.shop.app.model.service;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.TestDataGenerator;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

class WatchServiceImplTest {
    private WatchService service;

    @BeforeEach
    void setUp() {
        service = new WatchServiceImpl();
    }

    @Test
    void addNewWatch() {
        int initialSize = service.getAllWatches().size();

        service.addNewWatch(Brand.valueOf("CASIO"),
                BigDecimal.valueOf(100),
                Color.valueOf("WHITE"),
                Mechanism.valueOf("MECHANICAL"),
                Type.valueOf("WRIST"),
                LocalDate.parse("2023-09-02")
        );

        int newSize = service.getAllWatches().size();

        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void getAllWatches() {
        List<Watch> expectedList = new TestDataGenerator().getInitializedWatches();

        List<Watch> actualList = service.getAllWatches();

        assertEquals(expectedList, actualList);
    }

    @Test
    void getSortedByPrice() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> expected = new TestDataGenerator().getInitializedWatches();
        expected.sort(Comparator.comparing(Watch::getPrice));

        Field watchesField = WatchServiceImpl.class.getDeclaredField("watches");
        watchesField.setAccessible(true);

        List<Watch> watchesToAdd = new TestDataGenerator().getInitializedWatches();

        watchesField.set(service, watchesToAdd);

        List<Watch> actual = service.getSortedByPrice();

        assertEquals(expected, actual);
    }

    @Test
    void getSortedByColorWithReflection() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> expected = new TestDataGenerator().getInitializedWatches();
        expected.sort(Comparator.comparing(Watch::getColor));

        Field watchesField = WatchServiceImpl.class.getDeclaredField("watches");
        watchesField.setAccessible(true);

        List<Watch> watchesToAdd = new TestDataGenerator().getInitializedWatches();

        watchesField.set(service, watchesToAdd);

        List<Watch> actual = service.getSortedByColor();

        assertEquals(expected, actual);
    }

    @Test
    void getSortedByArrivalDate() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> expected = new TestDataGenerator().getInitializedWatches();
        expected.sort(Comparator.comparing(Watch::getPrice));

        Field watchesField = WatchServiceImpl.class.getDeclaredField("watches");
        watchesField.setAccessible(true);

        List<Watch> watchesToAdd = new TestDataGenerator().getInitializedWatches();

        watchesField.set(service, watchesToAdd);

        List<Watch> actual = service.getSortedByPrice();

        assertEquals(expected, actual);
    }

    @Test
    void getTotalCost() {
        List<Watch> watches = new TestDataGenerator().getInitializedWatches();

        BigDecimal expected = watches
                .stream()
                .map(Watch::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal actual = service.getTotalCost();

        assertEquals(expected, actual);
    }
}