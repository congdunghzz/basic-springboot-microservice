package com.congdunghzz.userService.Mapper;

import com.congdunghzz.userService.dto.UserResponse;
import com.congdunghzz.userService.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponse convertToUserResponse (User user){
        return new UserResponse(user.getName(), user.getGender(), user.getDob(), user.getEmail());
    }
}
