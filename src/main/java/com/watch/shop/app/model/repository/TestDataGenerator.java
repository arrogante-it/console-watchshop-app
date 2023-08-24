package com.watch.shop.app.model.repository;

import com.watch.shop.app.model.service.WatchService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestDataGenerator {
    private final WatchService watchService;

    public TestDataGenerator(WatchService watchService) {
        this.watchService = watchService;
    }

    public void initializeWatches() {
        watchService.addNewWatch(Brand.ARMANI, new BigDecimal(150.0), Color.BLACK, Mechanism.MECHANICAL,
                Type.WRIST,
                LocalDate.now());
        watchService.addNewWatch(Brand.CARNIVAL, new BigDecimal(100.0), Color.WHITE, Mechanism.QUARTZ,
                Type.WALL, LocalDate.now());
        watchService.addNewWatch(Brand.CASIO, new BigDecimal(200.0), Color.SILVER, Mechanism.KINETIC,
                Type.WRIST, LocalDate.now());
        watchService.addNewWatch(Brand.DW, new BigDecimal(250.0), Color.METAL_BLUE, Mechanism.CHRONOGRAPH,
                Type.DESKTOP, LocalDate.now());
        watchService.addNewWatch(Brand.ROLEX, new BigDecimal(300.0), Color.GOLD, Mechanism.MECHANICAL,
                Type.WRIST, LocalDate.now());
    }
}
