package com.watchshop.app.controller;

import com.watch.shop.app.controller.WatchController;
import static org.mockito.Mockito.*;

import com.watch.shop.app.model.repository.*;
import com.watch.shop.app.model.service.WatchService;
import com.watch.shop.app.view.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WatchControllerTest {
    private WatchView view;
    private WatchService service;
    private InputHandler inputHandler;

    private WatchController controller;

    @BeforeEach
    public void setup() {
        view = mock(WatchView.class);
        service = mock(WatchService.class);
        inputHandler = mock(InputHandler.class);
        controller = new WatchController(view, service, inputHandler);
    }

    @Test
    public void testRun_ExitChoice() {
        when(inputHandler.getUserInput()).thenReturn("0");

        controller.run();

        verify(view).displayMessage(Constants.OUTPUT_MESSAGE);
    }

    @Test
    public void testRunShowAllWatchesChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("1", "0");
        when(service.getAllWatches()).thenReturn(watches);

        controller.run();

        verify(service).getAllWatches();
        verify(view).showWatchCollection(watches);
    }

    @Test
    public void testRunSortByPriceChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("2", "0");
        when(service.getSortedByPrice()).thenReturn(watches);

        controller.run();

        verify(service).getSortedByPrice();
        verify(view).showWatchCollection(watches);
    }

    // todo THIS TEST FAILED
    @Test
    public void testRunSortByColorChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("3", "0");
        when(service.getSortedByColor()).thenReturn(watches);

        controller.run();

        verify(service).getSortedByColor();
        verify(view).showWatchCollection(watches);
    }

    @Test
    public void testRunSortByDateChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("4", "0");
        when(service.getSortedByArrivalDate()).thenReturn(watches);

        controller.run();

        verify(service).getSortedByArrivalDate();
        verify(view).showWatchCollection(watches);
    }

    @Test
    public void testRunDisplayTotalCostChoice() {
        BigDecimal totalCost = BigDecimal.valueOf(350);

        when(inputHandler.getUserInput()).thenReturn("5", "0");
        when(service.getTotalCost()).thenReturn(totalCost);

        controller.run();

        verify(service).getTotalCost();
        verify(view).displayMessage(Constants.TOTAL_COST_MESSAGE + totalCost);
    }

    // todo THIS TEST FAILED
    @Test
    public void testRunAddNewWatchChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("6", "0");
        when(service.getAllWatches()).thenReturn(watches);
        when(InputUtils.parseToLocalDate(any())).thenReturn(LocalDate.now());

        controller.run();

        verify(service).addNewWatch(Brand.CASIO,
                BigDecimal.valueOf(100),
                Color.WHITE,
                Mechanism.MECHANICAL,
                Type.WRIST,
                LocalDate.now());
        verify(view).displayMessage(Constants.ENTER_BRAND_MESSAGE);
        verify(view).displayMessage(Constants.ENTER_COLOR_MESSAGE);
        verify(view).displayMessage(Constants.ENTER_DATE_MESSAGE);
        verify(view).displayMessage(Constants.ENTER_MECHANISM_MESSAGE);
        verify(view).displayMessage(Constants.ENTER_PRICE_MESSAGE);
        verify(view).displayMessage(Constants.ENTER_TYPE_MESSAGE);
        verify(view).displayMessage(Constants.ADDING_WATCH_MESSAGE);
        verify(view).displayMessage(Constants.ADDED_WATCH_MESSAGE);
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

        List<Watch> watches = new ArrayList<>();
        Collections.addAll(watches, watch1, watch2, watch3);

        return watches;
    }
}