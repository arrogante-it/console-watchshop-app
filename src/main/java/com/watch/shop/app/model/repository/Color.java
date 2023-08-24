package com.watch.shop.app.model.repository;

public enum Color {
    BLACK("Black"),
    WHITE("White"),
    SILVER("Silver"),
    METAL_BLUE("Metal Blue"),
    GOLD("Gold"),
    DARK_GREEN("Dark Green");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
