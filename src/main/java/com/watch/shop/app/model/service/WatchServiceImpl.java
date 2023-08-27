package com.watch.shop.app.model.service;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.TestDataGenerator;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WatchServiceImpl implements WatchService {
    private final List<Watch> watches;

    public WatchServiceImpl() {
        this.watches = new TestDataGenerator().getInitializedWatches();
    }

    @Override
    public void addNewWatch(Brand brand, BigDecimal price, Color color, Mechanism mechanism, Type type, LocalDate arrivalDate) {
        Watch watch = new Watch.Builder()
                .brand(brand)
                .price(price)
                .color(color)
                .mechanism(mechanism)
                .type(type)
                .arrivalDate(arrivalDate)
                .build();

        List<Watch> updatedWatches = new ArrayList<>(watches);
        updatedWatches.add(watch);

        watches.clear();
        watches.addAll(updatedWatches);
    }

    @Override
    public List<Watch> getAllWatches() {
        return List.copyOf(watches);
    }

    @Override
    public void sortByPrice() {
        List<Watch> sortedWatches = new ArrayList<>(watches);
        sortedWatches.sort(Comparator.comparing(Watch::getPrice));

        watches.clear();
        watches.addAll(sortedWatches);
    }

    @Override
    public void sortByColor() {
        List<Watch> sortedWatches = new ArrayList<>(watches);
        sortedWatches.sort(Comparator.comparing(Watch::getColor));

        watches.clear();
        watches.addAll(sortedWatches);
    }

    @Override
    public void sortByArrivalDate() {
        List<Watch> sortedWatches = new ArrayList<>(watches);
        sortedWatches.sort(Comparator.comparing(Watch::getArrivalDate));

        watches.clear();
        watches.addAll(sortedWatches);
    }

    @Override
    public BigDecimal getTotalCost() {
        return watches.stream()
                .map(Watch::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
