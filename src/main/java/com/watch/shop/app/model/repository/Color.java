package com.watch.shop.app.model.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Color {
    BLACK("Black"),
    WHITE("White"),
    SILVER("Silver"),
    METAL_BLUE("Metal Blue"),
    GOLD("Gold"),
    DARK_GREEN("Dark Green");

    private final String name;
}
