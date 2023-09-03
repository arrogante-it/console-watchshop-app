package com.watch.shop.app.model.service;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;
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

    private static final Brand BRAND = Brand.DW;
    private static final BigDecimal PRICE = BigDecimal.valueOf(322);
    private static final Color COLOR = Color.GOLD;
    private static final Mechanism MECHANISM = Mechanism.QUARTZ;
    private static final Type TYPE = Type.WRIST;
    private static final LocalDate DATE = LocalDate.parse("2023-09-03");

    private WatchService service;

    @BeforeEach
    void setUp() {
        service = new WatchServiceImpl();
    }

    @Test
    void shouldCorrectlyAddNewWatch() {
        List<Watch> watches = new ArrayList<>();

        setWatchesFiled(watches);

        Watch watch = new Watch.Builder()
                .brand(BRAND)
                .price(PRICE)
                .color(COLOR)
                .mechanism(MECHANISM)
                .type(TYPE)
                .arrivalDate(DATE)
                .build();

        service.addNewWatch(BRAND, PRICE, COLOR, MECHANISM, TYPE, DATE);

        assertEquals(1, watches.size());
        assertEquals(watch, watches.iterator().next());
    }

    @Test
    void shouldCorrectlyGetAllWatches() {
        List<Watch> expectedList = buildWatchList();

        setWatchesFiled(buildWatchList());

        List<Watch> actualList = service.getAllWatches();

        assertEquals(expectedList, actualList);
    }

    @Test
    void shouldCorrectlyGetSortedByPrice() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> watches = buildWatchList();

        List<Watch> expected = new ArrayList<>(watches);
        expected.sort(Comparator.comparing(Watch::getPrice));

        Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
        watchesField.setAccessible(true);
        watchesField.set(service, watches);

        List<Watch> actual = service.getSortedByPrice();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyGetSortedByColor() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> watches = buildWatchList();

        List<Watch> expected = new ArrayList<>(buildWatchList());
        expected.sort(Comparator.comparing(Watch::getColor));

        Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
        watchesField.setAccessible(true);
        watchesField.set(service, watches);

        List<Watch> actual = service.getSortedByColor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyGetSortedByArrivalDate() throws NoSuchFieldException, IllegalAccessException {
        List<Watch> watches = buildWatchList();

        List<Watch> expected = new ArrayList<>(buildWatchList());
        expected.sort(Comparator.comparing(Watch::getPrice));

        Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
        watchesField.setAccessible(true);
        watchesField.set(service, watches);

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
                .arrivalDate(LocalDate.of(1999, 1, 1))
                .type(Type.valueOf("DESKTOP"))
                .mechanism(Mechanism.valueOf("KINETIC"))
                .price(BigDecimal.valueOf(200))
                .color(Color.valueOf("BLACK"))
                .brand(Brand.valueOf("ARMANI"))
                .build();

        Watch watch2 = new Watch.Builder()
                .arrivalDate(LocalDate.of(2023, 3, 3))
                .type(Type.valueOf("WALL"))
                .mechanism(Mechanism.valueOf("QUARTZ"))
                .price(BigDecimal.valueOf(50))
                .color(Color.valueOf("BLACK"))
                .brand(Brand.valueOf("DW"))
                .build();

        Watch watch3 = new Watch.Builder()
                .arrivalDate(LocalDate.of(2000, 2, 2))
                .type(Type.valueOf("WRIST"))
                .mechanism(Mechanism.valueOf("MECHANICAL"))
                .price(BigDecimal.valueOf(100))
                .color(Color.valueOf("WHITE"))
                .brand(Brand.valueOf("CASIO"))
                .build();

        return List.of(watch1, watch2, watch3);
    }

    private void setWatchesFiled(List<Watch> watches) {
        try {
            Field watchesField = WatchServiceImpl.class.getDeclaredField(LIST_NAME);
            watchesField.setAccessible(true);
            watchesField.set(service, watches);
        }catch (Exception e) {
            fail(e);
        }
    }
}