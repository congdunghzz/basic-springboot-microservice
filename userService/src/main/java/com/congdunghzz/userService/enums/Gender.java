package com.congdunghzz.userService.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHERS("others");

    private final String value;
    Gender (String value){
        this.value = value;
    }
}
