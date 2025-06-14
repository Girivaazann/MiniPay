package com.minipay.controller;

import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @PostMapping("/create-session")
    public String createCheckoutSession() throws Exception {

        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("https://www.google.com")
            .setCancelUrl("https://www.google.com")
            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency("gbp")
                            .setUnitAmount(1000L) // £10.00
                            .setProductData(
                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                    .setName("MiniPay Wallet Top-up")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build();

        Session session = Session.create(params);
        return session.getUrl(); // Stripe-hosted checkout page
    }
}

