package com.congdunghzz.userService.service;

import com.congdunghzz.userService.Mapper.UserMapper;
import com.congdunghzz.userService.dto.DepartmentResponse;
import com.congdunghzz.userService.dto.UserRequest;
import com.congdunghzz.userService.dto.UserResponse;
import com.congdunghzz.userService.enums.Gender;
import com.congdunghzz.userService.exceptionHandler.NotFoundException;
import com.congdunghzz.userService.feignClient.DepartmentClient;
import com.congdunghzz.userService.model.User;
import com.congdunghzz.userService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final DepartmentClient departmentClient;
    @Cacheable(cacheNames = "userList")
    public List<UserResponse> getALlUsers(){
        System.out.println("there is no data in cache memory");
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userMapper::convertToUserResponse).toList();
    }

    @Cacheable(cacheNames = "user", key = "#id")
    public UserResponse getUserById(int id){
        System.out.println("there is no data in cache memory");
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException("user with id: " + id + " is not found");
        }
        UserResponse response = userMapper.convertToUserResponse(user.get());
        DepartmentResponse departmentResponse = departmentClient.getDepartmentById(user.get().getDepartmentId());
        System.out.println("User serive: dp res: " + departmentResponse.getName());
        response.setDepartment(departmentResponse);
        return response;
    }
    @Caching(
           evict = {@CacheEvict(cacheNames = "userList", allEntries = true)}
    )
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
