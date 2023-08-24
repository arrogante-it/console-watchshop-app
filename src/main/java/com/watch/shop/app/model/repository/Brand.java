package com.watch.shop.app.model.repository;

public enum Brand {
    CASIO("Casio"),
    ARMANI("Armani"),
    ROLEX("Rolex"),
    CARNIVAL("Carnival"),
    DW("Daniel Wellington");

    private final String name;

    Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
