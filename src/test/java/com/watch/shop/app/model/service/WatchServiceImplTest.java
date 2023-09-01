package com.watch.shop.app.model.service;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.TestDataGenerator;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class WatchServiceImplTest {
    private static final Watch WATCH = new Watch.Builder().build(); // add watch here

    private WatchService service;

    @BeforeEach
    void setUp () {
        service = new WatchServiceImpl();
    }

//    @Test
//    void addNewWatch() {
//    }

//    @Test
//    void getAllWatches() {
//        //List<Watch> watches = buildWatchList();
//
//        service.getAllWatches();
//    }

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

//    @Test
//    void getTotalCost() {
//    }

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