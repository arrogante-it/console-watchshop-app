package com.watchshop.app.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Brand {
    BROLEX("Brolex"),
    ANOT_ROLEX("Anot-rolex"),
    CANY_ROLEX("Cany-rolex");

    private final String name;
}
