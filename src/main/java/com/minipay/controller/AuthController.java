package com.minipay.controller;



import com.minipay.dto.LoginRequest;

import com.minipay.dto.LoginResponse;

import com.minipay.entity.User;

import com.minipay.repository.UserRepository;

import com.minipay.security.JwtUtil;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/api/auth")

public class AuthController {



    @Autowired

    private UserRepository userRepository;



    @Autowired

    private JwtUtil jwtUtil;



    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // ✅ Step 1: Find user by email

        User user = userRepository.findByEmail(request.getEmail())

                .orElseThrow(() -> new RuntimeException("Invalid email or password"));



        // ✅ Step 2: Validate password (you can use encoder here for security)

        if (!user.getPassword().equals(request.getPassword())) {

            return ResponseEntity.badRequest().body("Invalid email or password");

        }



        // ✅ Step 3: Generate JWT token

        String token = jwtUtil.generateToken(user.getEmail());



        // ✅ Step 4: Return token

        return ResponseEntity.ok(new LoginResponse(token));

    }

}



