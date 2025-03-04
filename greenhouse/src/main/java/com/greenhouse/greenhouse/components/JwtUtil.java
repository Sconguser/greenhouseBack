package com.greenhouse.greenhouse.components;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String secret = "secret";

    public String generateToken(String username){
        return "aaaa";
    }
}
