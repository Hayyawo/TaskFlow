package com.example.taskflow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
}
