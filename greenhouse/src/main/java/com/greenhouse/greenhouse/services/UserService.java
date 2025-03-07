package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.models.Role;
import com.greenhouse.greenhouse.models.User;
import com.greenhouse.greenhouse.repositories.UserRepository;
import com.greenhouse.greenhouse.responses.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser (String username, String password) {
        if (userRepository.findByUsername(username)
                .isPresent())
        {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse loginUser (String username, String password){
        return null;
    }
}
