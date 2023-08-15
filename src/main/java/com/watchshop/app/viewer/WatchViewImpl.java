package com.watchshop.app.viewer;

import com.watchshop.app.controller.WatchController;
import com.watchshop.app.model.Watch;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WatchViewImpl implements WatchView {
    private WatchController watchController;

    public WatchViewImpl(WatchController watchController) {
        this.watchController = watchController;
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");


    @Override
    public void displayWatches() {
        displayWatchesList();
    }

    private void displayWatchesList() {
        if (watchController.getAllWatches().isEmpty()) {
            System.out.println("No available watches.");
        } else {
            System.out.println("Available watches:");
            for (Watch watch : watchController.getAllWatches()) {
                System.out.println(
                        "Brand: " + watch.getBrand() +
                                ", Price: $" + watch.getPrice() +
                                ", Color: " + watch.getColor() +
                                ", Arrival Date: " + DATE_FORMAT.format(watch.getArrivalDate()));
            }
        }
    }

    @Override
    public void displayTotalCost() {
        System.out.println("The total cost of all watches: " + watchController.getTotalCost());
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displaySortByPrice() {
        watchController.sortByPrice();
        displayWatchesList();
    }

    @Override
    public void displaySortByColor() {
        watchController.sortByColor();
        displayWatchesList();
    }

    @Override
    public void displaySortByArrivalDate() {
        watchController.sortByArrivalDate();
        displayWatchesList();
    }

    public void addNewWatchView() {
        System.out.print("Enter watch brand: ");
        String brand = watchController.inputBrand();

        System.out.print("Enter watch price: ");
        BigDecimal price = watchController.inputPrice();

        System.out.print("Enter watch color: ");
        String color = watchController.inputColor();

        System.out.print("Enter the date of watch receipt (в формате \"dd.MM.yyyy\"): ");
        Date arrivalDate = watchController.inputAndParseArrivalDate();

        System.out.println("Adding new watch...");
        watchController.addNewWatch(brand, price, color, arrivalDate);
        displayMessage("New Watch successfully added.");
    }

    public void viewer() {
        Scanner scanner = new Scanner(System.in);
        watchController.initializeWatches();
        while (true) {
            System.out.println("\n--- WatchShop ---");
            System.out.println("1. Show watches list");
            System.out.println("2. Sort and show watches by price");
            System.out.println("3. Sort and display watches by color");
            System.out.println("4. Sort and display watches by arrival date");
            System.out.println("5. Show the total cost of all watches");
            System.out.println("6. Add new watch");
            System.out.println("0. Go out");
            System.out.print("Choose an action: ");

            System.out.print('\n');

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Output from program...");
                    return;
                case 1:
                    displayWatches();
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
                    addNewWatchView();
                    break;
                default:
                    System.out.println("Not right choose. try again.");
            }
        }
    }
}