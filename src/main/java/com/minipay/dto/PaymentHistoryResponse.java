package com.minipay.dto;



import java.time.LocalDateTime;



public class PaymentHistoryResponse {



    private Long amount;

    private String method;

    private String status;

    private LocalDateTime timestamp;



    // No-arg constructor (required for serialization/deserialization)

    public PaymentHistoryResponse() {}



    // All-args constructor

    public PaymentHistoryResponse(Long amount, String method, String status, LocalDateTime timestamp) {

        this.amount = amount;

        this.method = method;

        this.status = status;

        this.timestamp = timestamp;

    }



    // Getters and Setters

    public Long getAmount() {

        return amount;

    }



    public void setAmount(Long amount) {

        this.amount = amount;

    }



    public String getMethod() {

        return method;

    }



    public void setMethod(String method) {

        this.method = method;

    }



    public String getStatus() {

        return status;

    }



    public void setStatus(String status) {

        this.status = status;

    }



    public LocalDateTime getTimestamp() {

        return timestamp;

    }



    public void setTimestamp(LocalDateTime timestamp) {

        this.timestamp = timestamp;

    }

}

