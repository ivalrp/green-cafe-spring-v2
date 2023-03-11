package com.green.cafee.springboot.v2.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum Gender {

    MALE("male","M"),
    FEMALE("female","F");

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
