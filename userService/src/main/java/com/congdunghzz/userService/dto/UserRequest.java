package com.congdunghzz.userService.dto;

import com.congdunghzz.userService.enums.Gender;

import java.time.LocalDate;

public record UserRequest(
         int id,
         String name,
         Gender gender,
         LocalDate dob,
         String email,
         String password
) {

}
