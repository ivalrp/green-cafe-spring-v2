package com.green.cafee.springboot.v2.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ItemCateory {

    A_LA_CARTE("a la carte"),
    APPERTIZERS("appertizers"),
    SIDES("sides"),
    EXTRAS("extras"),
    BEVERAGES("beverages");

    private String name;

    public String getName() {
        return name;
    }
}
