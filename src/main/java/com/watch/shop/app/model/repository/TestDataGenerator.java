package com.watch.shop.app.model.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDataGenerator {
    public List<Watch> getInitializedWatches() {
        List<Watch> watchList = new ArrayList<>();

        Watch watch1 = new Watch.Builder()
                .brand(Brand.ARMANI)
                .price( new BigDecimal(150.0))
                .color( Color.BLACK)
                .mechanism(Mechanism.MECHANICAL)
                .type(Type.WRIST)
                .arrivalDate(LocalDate.now())
                .build();

        Watch watch2 = new Watch.Builder()
                .brand(Brand.CASIO)
                .price( new BigDecimal(200.0))
                .color(Color.METAL_BLUE)
                .mechanism(Mechanism.KINETIC)
                .type(Type.WRIST)
                .arrivalDate(LocalDate.now())
                .build();

        Collections.addAll(watchList, watch1, watch2);

        return watchList;
    }
}
