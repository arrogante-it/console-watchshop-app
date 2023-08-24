package com.watch.shop.app.model.repository;

public enum Mechanism {
    QUARTZ("QUARTZ"),
    MECHANICAL("MECHANICAL"),
    CHRONOGRAPH("CHRONOGRAPH"),
    KINETIC("KINETIC");

    private final String name;

    Mechanism(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
