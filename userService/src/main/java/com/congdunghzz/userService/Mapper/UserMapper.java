package com.congdunghzz.userService.Mapper;

import com.congdunghzz.userService.dto.DepartmentResponse;
import com.congdunghzz.userService.dto.UserResponse;
import com.congdunghzz.userService.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponse convertToUserResponse (User user){
        return new UserResponse(user.getId()
                , user.getName(), user.getGender().name
                , user.getDob(), user.getEmail()
                , null);
    }
}
