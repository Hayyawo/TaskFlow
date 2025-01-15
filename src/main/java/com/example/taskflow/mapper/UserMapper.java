package com.example.taskflow.mapper;

import com.example.taskflow.model.User;
import com.example.taskflow.model.dto.UserRegisterRequest;
import org.springframework.security.core.userdetails.User.UserBuilder;

public class UserMapper {
    public static User map(UserRegisterRequest userRequest) {
        return new User(userRequest.username(), userRequest.password(), userRequest.email());
    }
}
