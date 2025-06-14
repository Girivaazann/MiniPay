package com.minipay.entity;



import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity

@Table(name = "users")

public class User {



    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @Column(unique = true, nullable = false)

    private String email;



    @Column(nullable = false)

    private String password;



    @Column(nullable = false)

    private String username;



    @Column(nullable = false)

    private String role = "USER"; // Default role



    @Column(name = "created_at", updatable = false)

    private LocalDateTime createdAt;



    @Column(name = "is_active")

    private Boolean isActive = true;



    // ✅ Constructors

    public User() {}



    public User(String email, String password, String username, String role) {

        this.email = email;

        this.password = password;

        this.username = username;

        this.role = role;

        this.createdAt = LocalDateTime.now();

        this.isActive = true;

    }



    // ✅ Pre-persist to auto-set createdAt

    @PrePersist

    protected void onCreate() {

        this.createdAt = LocalDateTime.now();

    }



    // ✅ Getters and Setters

    public Long getId() { return id; }



    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }



    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }



    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }



    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }



    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }



    public Boolean getIsActive() { return isActive; }

    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

}

