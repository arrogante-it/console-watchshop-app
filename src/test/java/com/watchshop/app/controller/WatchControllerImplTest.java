package com.watchshop.app.controller;

import com.watchshop.app.model.Brand;
import com.watchshop.app.model.Color;
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
        Brand brand = Brand.BROLEX;
        BigDecimal price = BigDecimal.valueOf(99.99);
        Color color = Color.BLACK;
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
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(200), Color.BLACK, new Date());
        watchController.addNewWatch(Brand.ANOT_ROLEX, BigDecimal.valueOf(100), Color.SILVER, new Date());
        watchController.addNewWatch(Brand.CANY_ROLEX, BigDecimal.valueOf(150), Color.WHITE, new Date());

        watchController.sortByPrice();

        List<Watch> sortedWatches = watchController.getAllWatches();

        assertEquals(BigDecimal.valueOf(100), sortedWatches.get(0).getPrice());
        assertEquals(BigDecimal.valueOf(150), sortedWatches.get(1).getPrice());
        assertEquals(BigDecimal.valueOf(200), sortedWatches.get(2).getPrice());
    }

    @Test
    public void testSortByColor() {
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(100),  Color.SILVER, new Date());
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(150), Color.WHITE, new Date());
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(50), Color.BLACK, new Date());

        watchController.sortByColor();

        List<Watch> sortedWatches = watchController.getAllWatches();

        assertEquals(Color.BLACK, sortedWatches.get(0).getColor());
        assertEquals(Color.WHITE, sortedWatches.get(1).getColor());
        assertEquals(Color.SILVER, sortedWatches.get(2).getColor());
    }

    @Test
    public void testSortByArrivalDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Date date1 = dateFormat.parse("01.01.2023");
        Date date2 = dateFormat.parse("02.01.2023");
        Date date3 = dateFormat.parse("03.01.2023");

        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(100),Color.SILVER, date3);
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(150), Color.SILVER, date2);
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(50), Color.SILVER, date1);

        watchController.sortByArrivalDate();

        List<Watch> sortedWatches = watchController.getAllWatches();

        assertEquals(date1, sortedWatches.get(0).getArrivalDate());
        assertEquals(date2, sortedWatches.get(1).getArrivalDate());
        assertEquals(date3, sortedWatches.get(2).getArrivalDate());
    }

    @Test
    public void testGetTotalCost() {
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(100), Color.SILVER, new Date());
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(150), Color.SILVER, new Date());
        watchController.addNewWatch(Brand.BROLEX, BigDecimal.valueOf(200), Color.SILVER, new Date());

        BigDecimal expectedHardCodedPriceSum = BigDecimal.valueOf(450);

        BigDecimal actualPriceSum = watchController.getTotalCost();

        assertEquals(expectedHardCodedPriceSum, actualPriceSum);
    }
}
