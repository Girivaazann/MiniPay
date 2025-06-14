package com.minipay.entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity

@Table(name = "payments")

public class Payment {



    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    private Long amount;

    private String method;     // e.g. CARD / UPI

    private String status;     // SUCCESS / FAILED / PENDING

    private LocalDateTime timestamp;



    @ManyToOne

    @JoinColumn(name = "user_id", nullable = false)

    private User user;



    // Constructors

    public Payment() {}



    public Payment(Long amount, String method, String status, LocalDateTime timestamp, User user) {

        this.amount = amount;

        this.method = method;

        this.status = status;

        this.timestamp = timestamp;

        this.user = user;

    }



    // Getters and Setters



    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



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



    public User getUser() {

        return user;

    }



    public void setUser(User user) {

        this.user = user;

    }

}

