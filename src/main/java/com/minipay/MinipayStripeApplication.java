package com.minipay; // replace with your actual package name



import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;





@SpringBootApplication

@EnableJpaRepositories(basePackages = "com.minipay.repository")

@EntityScan(basePackages = "com.minipay.entity")

public class MinipayStripeApplication {



    public static void main(String[] args) {

        SpringApplication.run(MinipayStripeApplication.class, args);

    }

}

