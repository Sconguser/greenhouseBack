package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.models.Role;
import com.greenhouse.greenhouse.models.UserEntity;
import org.springframework.security.core.userdetails.User;
import com.greenhouse.greenhouse.repositories.UserRepository;
import com.greenhouse.greenhouse.responses.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser (String username, String password) {
        if (userRepository.findByUsername(username)
                .isPresent())
        {
            throw new RuntimeException("User already exists");
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse loginUser (String username, String password) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRole()))
                .build();
    }
}
