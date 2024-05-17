package com.congdunghzz.departmentSevice.dto.user;


import java.time.LocalDate;

public record User (
        int id,
        String name,
        String gender,
        LocalDate dob,
        String email,
        int departmentId
) {
}