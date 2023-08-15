package com.watchshop.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Accessors(chain = true)
@Getter
@Setter
public class Watch {
    private String brand;
    private BigDecimal price;
    private String color;
    private Date arrivalDate;
}
