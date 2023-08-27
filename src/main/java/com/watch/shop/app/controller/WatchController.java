package com.watch.shop.app.controller;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.service.WatchService;
import static com.watch.shop.app.view.Constants.ADDED_WATCH_MESSAGE;
import static com.watch.shop.app.view.Constants.ADDING_WATCH_MESSAGE;
import static com.watch.shop.app.view.Constants.APPLICATION_TITLE;
import static com.watch.shop.app.view.Constants.ENTER_BRAND_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_COLOR_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_DATE_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_MECHANISM_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_PRICE_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_TYPE_MESSAGE;
import static com.watch.shop.app.view.Constants.MAIN_MENU;
import static com.watch.shop.app.view.Constants.NEXT_LINE_MESSAGE;
import static com.watch.shop.app.view.Constants.NOT_RIGHT_CHOOSE_MESSAGE;
import static com.watch.shop.app.view.Constants.OUTPUT_MESSAGE;
import static com.watch.shop.app.view.Constants.TOTAL_COST_MESSAGE;
import com.watch.shop.app.view.InputHandler;
import com.watch.shop.app.view.InputUtils;
import com.watch.shop.app.view.WatchView;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WatchController {
    private final WatchView view;
    private final WatchService service;
    private final InputHandler inputHandler;

    public WatchController(WatchView view, WatchService service,
                           InputHandler inputHandler) {
        this.view = view;
        this.service = service;
        this.inputHandler = inputHandler;
    }

    public void run() {
        while (true) {
            view.displayMessage(NEXT_LINE_MESSAGE);
            view.displayMessage(APPLICATION_TITLE);
            view.displayMessage(MAIN_MENU);

            int choice = Integer.parseInt(inputHandler.getUserInput());

            view.displayMessage(NEXT_LINE_MESSAGE);

            switch (choice) {
                case 0:
                    view.displayMessage(OUTPUT_MESSAGE);
                    return;
                case 1:
                    view.showWatchCollection(service.getAllWatches());
                    break;
                case 2:
                    displaySortByPrice();
                    break;
                case 3:
                    displaySortByColor();
                    break;
                case 4:
                    displaySortByArrivalDate();
                    break;
                case 5:
                    displayTotalCost();
                    break;
                case 6:
                    addNewWatch();
                    break;
                default:
                    view.displayMessage(NOT_RIGHT_CHOOSE_MESSAGE);
            }
        }
    }

    private void displaySortByPrice() {
        view.showWatchCollection(service.sortByPrice());
    }

    private void displaySortByColor() {
        view.showWatchCollection(service.sortByColor());
    }

    private void displaySortByArrivalDate() {
        view.showWatchCollection(service.sortByArrivalDate());
    }

    private void displayTotalCost() {
        view.displayMessage(TOTAL_COST_MESSAGE + service.getTotalCost());
    }

    private void addNewWatch() {
        view.displayMessage(ENTER_BRAND_MESSAGE);
        String brandName = inputHandler.getUserInput();

        view.displayMessage(ENTER_PRICE_MESSAGE);
        BigDecimal price = InputUtils.parseToBigDecimal(inputHandler.getUserInput());

        view.displayMessage(ENTER_COLOR_MESSAGE);
        String colorName = inputHandler.getUserInput();

        view.displayMessage(ENTER_MECHANISM_MESSAGE);
        String mechanismName = inputHandler.getUserInput();

        view.displayMessage(ENTER_TYPE_MESSAGE);
        String typeName = inputHandler.getUserInput();

        view.displayMessage(ENTER_DATE_MESSAGE);
        LocalDate arrivalDate = InputUtils.parseToLocalDate(inputHandler.getUserInput());

        view.displayMessage(ADDING_WATCH_MESSAGE);

        Brand brand = Brand.valueOf(brandName);
        Color color = Color.valueOf(colorName);
        Mechanism mechanism = Mechanism.valueOf(mechanismName);
        Type type = Type.valueOf(typeName);

        service.addNewWatch(brand, price, color, mechanism, type, arrivalDate);
        view.displayMessage(ADDED_WATCH_MESSAGE);
    }
}
