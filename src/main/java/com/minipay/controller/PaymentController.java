package com.minipay.controller;





import com.stripe.Stripe;

import com.stripe.exception.StripeException;

import com.stripe.model.PaymentIntent;

import com.stripe.param.PaymentIntentCreateParams;

import org.springframework.web.bind.annotation.*;



import java.util.HashMap;

import java.util.Map;



@RestController

@CrossOrigin(origins = "*") // Allows requests from any origin (React, HTML frontend, etc.)

public class PaymentController {



    @PostMapping("/create-payment-intent")

    public Map<String, String> createPaymentIntent(@RequestBody Map<String, Object> data) throws StripeException {

        Stripe.apiKey = ""; // Replace with your actual Stripe test secret key



        int amount = (int) data.get("amount");



        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()

            .setAmount((long) amount) // amount in pence (for GBP)

            .setCurrency("gbp")

            .build();



        PaymentIntent intent = PaymentIntent.create(params);



        Map<String, String> responseData = new HashMap<>();

        responseData.put("clientSecret", intent.getClientSecret());

        return responseData;

    }

}


