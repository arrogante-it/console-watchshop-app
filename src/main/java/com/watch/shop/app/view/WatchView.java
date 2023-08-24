package com.watch.shop.app.view;

import com.watch.shop.app.model.repository.Watch;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.watch.shop.app.view.Constants.NO_AVAILABLE_WATCHES;
import static com.watch.shop.app.view.Constants.AVAILABLE_WATCHES;

public class WatchView {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void showWatchCollection(List<Watch> watchList) {
        if (watchList.isEmpty()) {
            System.out.println(NO_AVAILABLE_WATCHES);
        } else {
            System.out.println(AVAILABLE_WATCHES);
            watchList.forEach(watch -> System.out.println(
                    String.format("Brand: %-15s | Price: $%-10s | Color: %-10s | Mechanism: %-15s | Type: %-10s | Arrival Date: %s",
                            watch.getBrand(),
                            watch.getPrice(),
                            watch.getColor(),
                            watch.getMechanism(),
                            watch.getType(),
                            formatter.format(watch.getArrivalDate()))));
        }
    }

    public void displayMessage(String message) {
        System.out.print(message);
    }
}