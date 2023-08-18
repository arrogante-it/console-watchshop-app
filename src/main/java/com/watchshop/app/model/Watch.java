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
    private Brand brand;
    private BigDecimal price;
    private Color color;
    private Date arrivalDate;
}
