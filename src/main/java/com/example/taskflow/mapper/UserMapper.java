package com.example.taskflow.mapper;

import com.example.taskflow.model.User;
import com.example.taskflow.model.dto.UserRegisterRequest;
import com.example.taskflow.model.dto.UserResponse;
import com.example.taskflow.model.dto.UserUpdateRequest;

public class UserMapper {
    public static User map(UserRegisterRequest userRequest) {
        return new User(userRequest.username(), userRequest.password(), userRequest.email());
    }

    public static UserResponse map(User user) {
        return new UserResponse(user.getUsername(), user.getEmail());
    }

    public static User map(UserUpdateRequest userUpdateRequest) {
        return new User(userUpdateRequest.username(), userUpdateRequest.email());
    }
}
