package com.example.tobenamed.model;

import org.springframework.validation.annotation.Validated;

@Validated
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
}
