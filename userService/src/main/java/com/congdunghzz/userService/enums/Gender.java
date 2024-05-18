package com.congdunghzz.userService.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHERS("others");

    public final String name;
    Gender (String value){
        this.name = value;
    }
}
