package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.requests.UserRequest;
import com.greenhouse.greenhouse.responses.UserResponse;
import com.greenhouse.greenhouse.services.UserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userService;

    public AuthController (AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                           UserDetailsService userDetailsService, UserDetailsServiceImpl userService)
    {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register (@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest.getUsername(), userRequest.getPassword());
    }

    @PostMapping("/login")
    public UserResponse login (@RequestBody UserRequest userRequest) {
        return userService.loginUser(userRequest.getUsername(), userRequest.getPassword());
    }
}
