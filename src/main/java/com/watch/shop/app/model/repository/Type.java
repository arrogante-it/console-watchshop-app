package com.watch.shop.app.model.repository;

public enum Type {
    DESKTOP("DESKTOP"),
    WRIST("WRIST"),
    WALL("WALL");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
