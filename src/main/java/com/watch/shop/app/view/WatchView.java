package com.watch.shop.app.view;

import com.watch.shop.app.model.repository.Watch;

import java.util.List;

import static com.watch.shop.app.view.Constants.AVAILABLE_WATCHES_MESSAGE;
import static com.watch.shop.app.view.Constants.NEXT_LINE_MESSAGE;
import static com.watch.shop.app.view.Constants.NO_AVAILABLE_WATCHES_MESSAGE;

public class WatchView {
    public void showWatchCollection(List<Watch> watchList) {
        if (watchList.isEmpty()) {
            displayMessage(NO_AVAILABLE_WATCHES_MESSAGE);
            return;
        }

        displayMessage(AVAILABLE_WATCHES_MESSAGE);

        watchList.forEach(watch -> displayMessage(NEXT_LINE_MESSAGE + watch.toString()));
    }

    public void displayMessage(String message) {
        System.out.print(message);
    }
}