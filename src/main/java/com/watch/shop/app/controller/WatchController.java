package com.watch.shop.app.controller;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.service.WatchService;
import static com.watch.shop.app.view.Constants.ADDED_WATCH_MESSAGE;
import static com.watch.shop.app.view.Constants.ADDING_WATCH_MESSAGE;
import static com.watch.shop.app.view.Constants.ENTER_BRAND;
import static com.watch.shop.app.view.Constants.ENTER_COLOR;
import static com.watch.shop.app.view.Constants.ENTER_DATE;
import static com.watch.shop.app.view.Constants.ENTER_MECHANISM;
import static com.watch.shop.app.view.Constants.ENTER_PRICE;
import static com.watch.shop.app.view.Constants.ENTER_TYPE;
import static com.watch.shop.app.view.Constants.MENU;
import static com.watch.shop.app.view.Constants.NEXT_LINE;
import static com.watch.shop.app.view.Constants.NOT_RIGHT_CHOOSE;
import static com.watch.shop.app.view.Constants.OUTPUT;
import static com.watch.shop.app.view.Constants.TITLE;
import static com.watch.shop.app.view.Constants.TOTAL_COST;
import com.watch.shop.app.view.InputHandler;
import com.watch.shop.app.view.WatchView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMessage(TITLE);
            view.displayMessage(MENU);

            int choice = scanner.nextInt();
            scanner.nextLine();

            view.displayMessage(NEXT_LINE);

            switch (choice) {
                case 0:
                    view.displayMessage(OUTPUT);
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
                    view.displayMessage(NOT_RIGHT_CHOOSE);
            }
        }
    }

    private void displaySortByPrice() {
        service.sortByPrice();
        view.showWatchCollection(service.getAllWatches());
    }

    private void displaySortByColor() {
        service.sortByColor();
        view.showWatchCollection(service.getAllWatches());
    }

    private void displaySortByArrivalDate() {
        service.sortByArrivalDate();
        view.showWatchCollection(service.getAllWatches());
    }

    private void displayTotalCost() {
        System.out.println(TOTAL_COST + service.getTotalCost());
    }

    private void addNewWatch() {
        view.displayMessage(ENTER_BRAND);
        String brandName = (String) inputHandler.inputData();

        view.displayMessage(ENTER_PRICE);
        BigDecimal price = (BigDecimal) inputHandler.inputData();

        view.displayMessage(ENTER_COLOR);
        String colorName = (String) inputHandler.inputData();

        view.displayMessage(ENTER_MECHANISM);
        String mechanismName = (String) inputHandler.inputData();

        view.displayMessage(ENTER_TYPE);
        String typeName = (String) inputHandler.inputData();

        view.displayMessage(ENTER_DATE);
        LocalDate arrivalDate = (LocalDate) inputHandler.inputData();

        view.displayMessage(ADDING_WATCH_MESSAGE);

        Brand brand = Brand.valueOf(brandName);
        Color color = Color.valueOf(colorName);
        Mechanism mechanism = Mechanism.valueOf(mechanismName);
        Type type = Type.valueOf(typeName);

        service.addNewWatch(brand, price, color, mechanism, type, arrivalDate);
        view.displayMessage(ADDED_WATCH_MESSAGE);
    }
}
