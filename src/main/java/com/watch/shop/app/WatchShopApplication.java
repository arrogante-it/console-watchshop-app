package com.watch.shop.app;

import com.watch.shop.app.controller.WatchController;
import com.watch.shop.app.model.service.WatchService;
import com.watch.shop.app.model.service.WatchServiceImpl;
import com.watch.shop.app.view.InputHandler;
import com.watch.shop.app.view.WatchView;

public class WatchShopApplication {
    public static void main(String[] args) {
        WatchView view = new WatchView();
        WatchService service = new WatchServiceImpl();
        InputHandler inputHandler = new InputHandler();

        WatchController controller = new WatchController(view, service, inputHandler);

        controller.run();
    }
}
