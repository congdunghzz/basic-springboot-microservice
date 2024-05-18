package com.congdunghzz.userService.dto;

import com.congdunghzz.userService.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private int id;
    private String name;
    private String gender;
    private LocalDate dob;
    private String email;
    private DepartmentResponse department;
}
