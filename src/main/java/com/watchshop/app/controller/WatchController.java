package com.watchshop.app.controller;

import com.watchshop.app.model.Watch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface WatchController {
    void initializeWatches();

    void addNewWatch(String brand, BigDecimal price, String color, Date arrivalDate);

    List<Watch> getAllWatches();

    void sortByPrice();

    void sortByColor();

    void sortByArrivalDate();

    BigDecimal getTotalCost();

    String inputBrand();

    BigDecimal inputPrice();

    String inputColor();

    Date inputAndParseArrivalDate();
}
