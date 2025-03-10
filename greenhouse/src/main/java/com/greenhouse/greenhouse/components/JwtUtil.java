package com.greenhouse.greenhouse.components;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String secret = "secretsecretsecretsecretsecretsecretsecretsecretsecret";
    private static final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    private final int tokenExpiration = 1000 * 60 * 60;

    public String generateToken (String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(key)
                .compact();
    }
}
