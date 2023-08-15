package com.watchshop.app;

import com.watchshop.app.controller.WatchController;
import com.watchshop.app.controller.WatchControllerImpl;
import com.watchshop.app.model.Watch;
import com.watchshop.app.viewer.WatchView;
import com.watchshop.app.viewer.WatchViewImpl;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class WatchShopApplication {
    private final WatchView watchView;

    public void run() {
        watchView.viewer();
    }

    public static void main(String[] args) {
        List<Watch> watchList = new ArrayList<>();
        WatchController watchController = new WatchControllerImpl(watchList);

        WatchView watchView = new WatchViewImpl(watchController);

        WatchShopApplication application = new WatchShopApplication(watchView);
        application.run();
    }
}
