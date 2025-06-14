package com.minipay.dto;



public class LoginResponse {



    private String token;



    // No-args constructor (required for JSON serialization)

    public LoginResponse() {

    }



    // All-args constructor

    public LoginResponse(String token) {

        this.token = token;

    }



    // Getter

    public String getToken() {

        return token;

    }



    // Setter (optional, useful for serialization or modification)

    public void setToken(String token) {

        this.token = token;

    }

}

