package com.watchshop.app.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Color {
    BLACK("Black"),
    WHITE("White"),
    SILVER("Silver");

    private final String name;
}
