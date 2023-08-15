package com.watchshop.app.controller;

import com.watchshop.app.model.Watch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WatchControllerImplTest {
    private WatchControllerImpl watchController;

    @BeforeEach
    public void setUp() {
        List<Watch> watches = new ArrayList<>();
        watchController = new WatchControllerImpl(watches);
    }

    @Test
    public void testAddNewWatch() {
        String brand = "TestBrand";
        BigDecimal price = BigDecimal.valueOf(99.99);
        String color = "TestColor";
        Date arrivalDate = new Date();

        watchController.addNewWatch(brand, price, color, arrivalDate);

        List<Watch> watches = watchController.getAllWatches();
        assertEquals(1, watches.size());

        Watch addedWatch = watches.get(0);
        assertEquals(brand, addedWatch.getBrand());
        assertEquals(price, addedWatch.getPrice());
        assertEquals(color, addedWatch.getColor());
        assertEquals(arrivalDate, addedWatch.getArrivalDate());
    }

    @Test
    public void testSortByPrice() {
        watchController.addNewWatch("TestBrand1", BigDecimal.valueOf(200), "TestColor1", new Date());
        watchController.addNewWatch("TestBrand2", BigDecimal.valueOf(100), "TestColor2", new Date());
        watchController.addNewWatch("TestBrand3", BigDecimal.valueOf(150), "TestColor3", new Date());

        watchController.sortByPrice();

        List<Watch> sortedWatches = watchController.getAllWatches();

        assertEquals(BigDecimal.valueOf(100), sortedWatches.get(0).getPrice());
        assertEquals(BigDecimal.valueOf(150), sortedWatches.get(1).getPrice());
        assertEquals(BigDecimal.valueOf(200), sortedWatches.get(2).getPrice());
    }

    @Test
    public void testSortByColor() {
        watchController.addNewWatch("TestBrand1", BigDecimal.valueOf(100), "B_Color", new Date());
        watchController.addNewWatch("TestBrand2", BigDecimal.valueOf(150), "C_Color", new Date());
        watchController.addNewWatch("TestBrand3", BigDecimal.valueOf(50), "A_Color", new Date());

        watchController.sortByColor();

        List<Watch> sortedWatches = watchController.getAllWatches();

        assertEquals("A_Color", sortedWatches.get(0).getColor());
        assertEquals("B_Color", sortedWatches.get(1).getColor());
        assertEquals("C_Color", sortedWatches.get(2).getColor());
    }

    @Test
    public void testSortByArrivalDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Date date1 = dateFormat.parse("01.01.2023");
        Date date2 = dateFormat.parse("02.01.2023");
        Date date3 = dateFormat.parse("03.01.2023");

        watchController.addNewWatch("TestBrand1", BigDecimal.valueOf(100), "B_Color", date3);
        watchController.addNewWatch("TestBrand2", BigDecimal.valueOf(150), "C_Color", date2);
        watchController.addNewWatch("TestBrand3", BigDecimal.valueOf(50), "A_Color", date1);

        watchController.sortByArrivalDate();

        List<Watch> sortedWatches = watchController.getAllWatches();

        assertEquals(date1, sortedWatches.get(0).getArrivalDate());
        assertEquals(date2, sortedWatches.get(1).getArrivalDate());
        assertEquals(date3, sortedWatches.get(2).getArrivalDate());
    }

    @Test
    public void testGetTotalCost() {
        watchController.addNewWatch("TestBrand1", BigDecimal.valueOf(100), "B_Color", new Date());
        watchController.addNewWatch("TestBrand2", BigDecimal.valueOf(150), "C_Color", new Date());
        watchController.addNewWatch("TestBrand3", BigDecimal.valueOf(200), "A_Color", new Date());

        BigDecimal expectedHardCodedPriceSum = BigDecimal.valueOf(450);

        BigDecimal actualPriceSum = watchController.getTotalCost();

        assertEquals(expectedHardCodedPriceSum, actualPriceSum);
    }
}
