package com.congdunghzz.userService.controller;

import com.congdunghzz.userService.dto.UserRequest;
import com.congdunghzz.userService.dto.UserResponse;
import com.congdunghzz.userService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getALlUsers());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> register (@RequestBody UserRequest request){
        return ResponseEntity.ok().body(userService.register(request));
    }
}
