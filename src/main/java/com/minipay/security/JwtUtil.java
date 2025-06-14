package com.minipay.security;



import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;



import java.util.Date;



@Component

public class JwtUtil {



    private final String SECRET = "minipay-secret-key"; // 🔒 Store securely in production



    // Generate JWT token after successful login

    public String generateToken(String email) {

        return Jwts.builder()

                .setSubject(email) // email = user's identity

                .setIssuedAt(new Date(System.currentTimeMillis()))

                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours

                .signWith(SignatureAlgorithm.HS256, SECRET)

                .compact();

    }



    // Extract email from token

    public String extractEmail(String token) {

        return extractAllClaims(token).getSubject();

    }



    // Helper method to extract claims

    private Claims extractAllClaims(String token) {

        return Jwts.parser()

                .setSigningKey(SECRET)

                .parseClaimsJws(token)

                .getBody();

    }



    // Optional: check if token is expired

    public boolean isTokenExpired(String token) {

        return extractAllClaims(token).getExpiration().before(new Date());

    }

}

