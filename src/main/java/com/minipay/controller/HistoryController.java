package com.minipay.controller;

import com.minipay.dto.PaymentHistoryResponse;
import com.minipay.entity.User;
import com.minipay.repository.UserRepository;
import com.minipay.security.JwtUtil;
import com.minipay.service.PaymentHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class HistoryController {

    @Autowired
    private PaymentHistoryService historyService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/history")
    public List<PaymentHistoryResponse> getHistory(@RequestHeader("Authorization") String authHeader) {
        // Example: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
        String token = authHeader.substring(7); // remove "Bearer "
        String email = jwtUtil.extractEmail(token); // extract email from JWT

        // Fetch user from DB using email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        // Fetch and return payment history for the user
        return historyService.getPaymentHistory(user);
    }
}

