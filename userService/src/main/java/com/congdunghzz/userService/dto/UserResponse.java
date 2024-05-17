package com.congdunghzz.userService.dto;

import com.congdunghzz.userService.enums.Gender;

import java.time.LocalDate;

public record UserResponse (
        int id,
        String name,
        String gender,
        LocalDate dob,
        String email,
        int departmentId
) {
}
