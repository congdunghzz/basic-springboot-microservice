package com.congdunghzz.userService.dto;

import com.congdunghzz.userService.enums.Gender;

import java.time.LocalDate;

public record UserResponse (
        String name,
        Gender gender,
        LocalDate dob,
        String email
) {
}
