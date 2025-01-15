package com.example.taskflow.mapper;

import com.example.taskflow.model.User;
import com.example.taskflow.model.dto.UserRegisterRequest;

public class UserMapper {
    public static User map(UserRegisterRequest userRequest) {
        return User.builder()
                .email(userRequest.email())
                .password(userRequest.password())
                .email(userRequest.email())
                .build();
    }
}
