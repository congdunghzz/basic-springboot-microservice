package com.congdunghzz.userService.service;

import com.congdunghzz.userService.Mapper.UserMapper;
import com.congdunghzz.userService.dto.UserRequest;
import com.congdunghzz.userService.dto.UserResponse;
import com.congdunghzz.userService.enums.Gender;
import com.congdunghzz.userService.exceptionHandler.NotFoundException;
import com.congdunghzz.userService.model.User;
import com.congdunghzz.userService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public List<UserResponse> getALlUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::convertToUserResponse).toList();
    }

    public UserResponse getUserById(int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException("user with id: " + id + " is not found");
        }
        return userMapper.convertToUserResponse(user.get());
    }

    public UserResponse register(UserRequest request){
        if (request.name() == null
                || request.gender() == null
                || request.dob()==null
                || request.email() == null
                || request.password() == null
                || request.departmentId() == 0){

            throw new NotFoundException("Please fill all the fields");
        }
        Gender gender = Gender.valueOf(request.gender().toUpperCase());
        User user = User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .gender(gender)
                .dob(request.dob())
                .departmentId(request.departmentId())
                .build();
        return userMapper.convertToUserResponse(userRepository.save(user));
    }
}
