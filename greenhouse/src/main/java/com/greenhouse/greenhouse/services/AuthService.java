package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.models.Role;
import com.greenhouse.greenhouse.models.UserEntity;
import com.greenhouse.greenhouse.repositories.UserRepository;
import com.greenhouse.greenhouse.requests.UserRequest;
import com.greenhouse.greenhouse.responses.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final String jwtSecretKey;
    private final UserRepository userRepository;

    public AuthService (AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                        @Value("${jwt.secret.key}") String jwtSecretKey, UserRepository userRepository)
    {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtSecretKey = jwtSecretKey;
        this.userRepository = userRepository;
    }

    public LoginResponse authenticateAndGenerateToken (String username, String password) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        // Fetch user details from the database
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Generate the JWT token
        String token = Jwts.builder()
                .subject(user.getUsername())
                .claim("roles", user.getRole()
                        .name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(SignatureAlgorithm.HS256, jwtSecretKey)
                .compact();

        // Return the token and user details
        return new LoginResponse(token, user.getUsername(), user.getRole()
                .name());
    }

    public boolean register (String username, String password) {
        if (userRepository.findByUsername(username)
                .isPresent())
        {
            return false;
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.USER);
        userRepository.save(user);
        return true;
    }
}