package com.minipay.config;

import com.stripe.Stripe;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct; // ← use this!

@Component
public class StripeConfig {

    @PostConstruct
    public void init() {
        Stripe.apiKey = ""; // Your secret key
    }
}