package com.watch.shop.app.model.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Watch {
    private Brand brand;
    private BigDecimal price;
    private Color color;
    private String model;
    private Mechanism mechanism;
    private Type type;
    private LocalDate arrivalDate;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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
            Watch watch = new Watch();
            watch.brand = this.brand;
            watch.price = this.price;
            watch.color = this.color;
            watch.model = this.model;
            watch.mechanism = this.mechanism;
            watch.type = this.type;
            watch.arrivalDate = this.arrivalDate;
            return watch;
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Mechanism getMechanism() {
        return mechanism;
    }

    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
