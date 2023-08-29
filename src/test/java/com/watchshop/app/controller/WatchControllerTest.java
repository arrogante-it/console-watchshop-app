package com.watchshop.app.controller;

import com.watch.shop.app.controller.WatchController;
import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;
import com.watch.shop.app.model.service.WatchService;
import static com.watch.shop.app.view.Constants.ADDED_WATCH_MESSAGE;
import static com.watch.shop.app.view.Constants.ADDING_WATCH_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_BRAND_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_COLOR_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_DATE_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_MECHANISM_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_PRICE_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_TYPE_MESSAGE;
import static com.watch.shop.app.view.Constants.OUTPUT_MESSAGE;
import static com.watch.shop.app.view.Constants.TOTAL_COST_MESSAGE;
import com.watch.shop.app.view.InputHandler;
import com.watch.shop.app.view.WatchView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WatchControllerTest {
    private static final String BRAND = "CASIO";
    private static final String PRICE = "100";
    private static final String COLOR = "WHITE";
    private static final String MECHANISM = "MECHANICAL";
    private static final String TYPE = "WRIST";
    private static final String DATE = "29.08.2023";

    private WatchView view;
    private WatchService service;
    private InputHandler inputHandler;

    private WatchController controller;

    @BeforeEach
    void setup() {
        view = mock(WatchView.class);
        service = mock(WatchService.class);
        inputHandler = mock(InputHandler.class);
        controller = new WatchController(view, service, inputHandler);
    }

    @Test
    void testRun_ExitChoice() {
        when(inputHandler.getUserInput()).thenReturn("0");

        controller.run();

        verify(view).displayMessage(OUTPUT_MESSAGE);
    }

    @Test
    void testRunShowAllWatchesChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("1", "0");
        when(service.getAllWatches()).thenReturn(watches);

        controller.run();

        verify(service).getAllWatches();
        verify(view).showWatchCollection(watches);
    }

    @Test
    void testRunSortByPriceChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("2", "0");
        when(service.getSortedByPrice()).thenReturn(watches);

        controller.run();

        verify(service).getSortedByPrice();
        verify(view).showWatchCollection(watches);
    }

    @Test
    void testRunSortByColorChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("3", "0");
        when(service.getSortedByColor()).thenReturn(watches);

        controller.run();

        verify(service).getSortedByColor();
        verify(view).showWatchCollection(watches);
    }

    @Test
    void testRunSortByDateChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("4", "0");
        when(service.getSortedByArrivalDate()).thenReturn(watches);

        controller.run();

        verify(service).getSortedByArrivalDate();
        verify(view).showWatchCollection(watches);
    }

    @Test
    void testRunDisplayTotalCostChoice() {
        BigDecimal totalCost = BigDecimal.valueOf(350);

        when(inputHandler.getUserInput()).thenReturn("5", "0");
        when(service.getTotalCost()).thenReturn(totalCost);

        controller.run();

        verify(service).getTotalCost();
        verify(view).displayMessage(TOTAL_COST_MESSAGE + totalCost);
    }

    @Test
    void testRunAddNewWatchChoice() {
        List<Watch> watches = buildWatchList();

        when(inputHandler.getUserInput()).thenReturn("6",
                BRAND,
                PRICE,
                COLOR,
                MECHANISM,
                TYPE,
                DATE,
                "0");
//        when(service.getAllWatches()).thenReturn(watches);

        controller.run();

        verify(service).addNewWatch(Brand.valueOf(BRAND),
                BigDecimal.valueOf(Integer.parseInt(PRICE)),
                Color.valueOf(COLOR),
                Mechanism.valueOf(MECHANISM),
                Type.valueOf(TYPE),
                LocalDate.of(2023,8,29));

        verify(view).displayMessage(ENTER_BRAND_MESSAGE);
        verify(view).displayMessage(ENTER_COLOR_MESSAGE);
        verify(view).displayMessage(ENTER_DATE_MESSAGE);
        verify(view).displayMessage(ENTER_MECHANISM_MESSAGE);
        verify(view).displayMessage(ENTER_PRICE_MESSAGE);
        verify(view).displayMessage(ENTER_TYPE_MESSAGE);
        verify(view).displayMessage(ADDING_WATCH_MESSAGE);
        verify(view).displayMessage(ADDED_WATCH_MESSAGE);
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