package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.requests.UserRequest;
import com.greenhouse.greenhouse.responses.UserResponse;
import com.greenhouse.greenhouse.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register (@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest.getUsername(), userRequest.getPassword());
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest userRequest){
        return userService.loginUser(userRequest.getUsername(), userRequest.getPassword());
    }
}
