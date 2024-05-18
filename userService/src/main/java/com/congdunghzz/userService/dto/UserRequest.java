package com.congdunghzz.userService.dto;

import com.congdunghzz.userService.enums.Gender;

import java.time.LocalDate;

public record UserRequest(
         String name,
         String gender,
         LocalDate dob,
         String email,
         String password,
         int departmentId
) {

}
