package com.aspiro.user.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Unique identifier, e.g., "john_doe"
    private String email; // Primary email, used for login
    private String password; // Password for authentication
    private String role; // Role could be USER, ADMIN, MENTOR, etc.

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
