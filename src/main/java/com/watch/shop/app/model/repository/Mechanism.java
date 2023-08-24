package com.watch.shop.app.model.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Mechanism {
    QUARTZ("QUARTZ"),
    MECHANICAL("MECHANICAL"),
    CHRONOGRAPH("CHRONOGRAPH"),
    KINETIC("KINETIC");

    private final String name;
}
