package com.watch.shop.app.model.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Type {
    DESKTOP("DESKTOP"),
    WRIST("WRIST"),
    WALL("WALL");

    private final String name;
}
