package com.watch.shop.app.model.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Brand {
    CASIO("Casio"),
    ARMANI("Armani"),
    ROLEX("Rolex"),
    CARNIVAL("Carnival"),
    DW("Daniel Wellington");

    private final String name;
}
