package com.watch.shop.app.model.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Watch {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final Brand brand;
    private final BigDecimal price;
    private final Color color;
    private final String model;
    private final Mechanism mechanism;
    private final Type type;
    private final LocalDate arrivalDate;

    private Watch(Builder builder) {
        this.brand = builder.brand;
        this.price = builder.price;
        this.color = builder.color;
        this.model = builder.model;
        this.mechanism = builder.mechanism;
        this.type = builder.type;
        this.arrivalDate = builder.arrivalDate;
    }

    public static class Builder {
        private Brand brand;
        private BigDecimal price;
        private Color color;
        private String model;
        private Mechanism mechanism;
        private Type type;
        private LocalDate arrivalDate;

        public Builder brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder mechanism(Mechanism mechanism) {
            this.mechanism = mechanism;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder arrivalDate(LocalDate arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        public Watch build() {
            return new Watch(this);
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public Mechanism getMechanism() {
        return mechanism;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("Brand: %-15s | Price: $%-10s | Color: %-10s | Mechanism: %-15s | Type: %-10s | Arrival Date: %s",
                brand,
                price,
                color,
                mechanism,
                type,
                FORMATTER.format(arrivalDate));
    }
}
