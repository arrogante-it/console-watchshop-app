package com.watch.shop.app.model.service;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class WatchServiceImplTest {
    private static final String LIST_NAME = "watches";

    private WatchService service;

    @BeforeEach
    void setUp() {
        service = new WatchServiceImpl();
    }

    @Test
    void shouldCorrectlyAddNewWatch() {
        int initialSize = getWatchesListSize(service);

        service.addNewWatch(Brand.CASIO,
                BigDecimal.valueOf(100),
                Color.WHITE,
                Mechanism.MECHANICAL,
                Type.WRIST,
                LocalDate.parse("2023-09-02")
        );

        int newSize = getWatchesListSize(service);

        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void shouldCorrectlyGetAllWatches() {
        List<Watch> expectedList = buildWatchList();

        List<Watch> actualList = service.getAllWatches();

        assertEquals(expectedList, actualList);
    }

    @Test
    void shouldCorrectlyGetSortedByPrice() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> expected = new ArrayList<>(buildWatchList());
        expected.sort(Comparator.comparing(Watch::getPrice));

        Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
        watchesField.setAccessible(true);

        List<Watch> watchesToAdd = buildWatchList();

        watchesField.set(service, watchesToAdd);

        List<Watch> actual = service.getSortedByPrice();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyGetSortedByColor() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> expected = new ArrayList<>(buildWatchList());
        expected.sort(Comparator.comparing(Watch::getColor));

        Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
        watchesField.setAccessible(true);

        List<Watch> watchesToAdd = buildWatchList();

        watchesField.set(service, watchesToAdd);

        List<Watch> actual = service.getSortedByColor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyGetSortedByArrivalDate() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> expected = new ArrayList<>(buildWatchList());
        expected.sort(Comparator.comparing(Watch::getPrice));

        Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
        watchesField.setAccessible(true);

        List<Watch> watchesToAdd = buildWatchList();

        watchesField.set(service, watchesToAdd);

        List<Watch> actual = service.getSortedByPrice();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyGetTotalCost() {
        List<Watch> watches = buildWatchList();

        BigDecimal expected = watches
                .stream()
                .map(Watch::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal actual = service.getTotalCost();

        assertEquals(expected, actual);
    }

    private List<Watch> buildWatchList() {
        Watch watch1 = new Watch.Builder()
                .brand(Brand.ARMANI)
                .price(new BigDecimal(150.0))
                .color(Color.BLACK)
                .mechanism(Mechanism.MECHANICAL)
                .type(Type.WRIST)
                .arrivalDate(LocalDate.now())
                .build();

        Watch watch2 = new Watch.Builder()
                .brand(Brand.CASIO)
                .price(new BigDecimal(200.0))
                .color(Color.METAL_BLUE)
                .mechanism(Mechanism.KINETIC)
                .type(Type.WRIST)
                .arrivalDate(LocalDate.now())
                .build();

        return List.of(watch1, watch2);
    }

    private int getWatchesListSize(WatchService service) {
        List<Watch> watches = emptyList();
        try {
            Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
            watchesField.setAccessible(true);
            watches = (List<Watch>) watchesField.get(service);

        }catch (Exception e) {
            fail(e);
        }
        return watches.size();
    }
}