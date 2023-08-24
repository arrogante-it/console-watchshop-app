package com.watch.shop.app;

import com.watch.shop.app.controller.WatchController;
import com.watch.shop.app.model.repository.TestDataGenerator;
import com.watch.shop.app.model.repository.Watch;
import com.watch.shop.app.model.service.WatchService;
import com.watch.shop.app.model.service.WatchServiceImpl;
import com.watch.shop.app.view.InputHandler;
import com.watch.shop.app.view.WatchView;

import java.util.ArrayList;
import java.util.List;

public class WatchShopApplication {
    public static void main(String[] args) {
        List<Watch> watchList = new ArrayList<>();

        WatchView view = new WatchView();

        WatchService service = new WatchServiceImpl(watchList);

        TestDataGenerator dataGenerator = new TestDataGenerator(service);

        InputHandler inputHandler = new InputHandler();

        WatchController controller = new WatchController(view, service, dataGenerator, inputHandler);
        controller.run();
    }
}
