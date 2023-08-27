package com.watch.shop.app.model.service;

import com.watch.shop.app.model.repository.Brand;
import com.watch.shop.app.model.repository.Color;
import com.watch.shop.app.model.repository.Mechanism;
import com.watch.shop.app.model.repository.Type;
import com.watch.shop.app.model.repository.Watch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface WatchService {
    List<Watch> getAllWatches();

    void addNewWatch(Brand brand, BigDecimal price, Color color, Mechanism mechanism, Type type, LocalDate arrivalDate);

    List<Watch> sortByPrice();

    List<Watch> sortByColor();

    List<Watch> sortByArrivalDate();

    BigDecimal getTotalCost();
}
