package com.example.taskflow.service;

import com.example.taskflow.mapper.UserMapper;
import com.example.taskflow.model.User;
import com.example.taskflow.model.dto.UserLoginRequest;
import com.example.taskflow.model.dto.UserRegisterRequest;
import com.example.taskflow.model.dto.UserResponse;
import com.example.taskflow.model.dto.UserUpdateRequest;
import com.example.taskflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegisterRequest userRequest) {
        User user = UserMapper.map(userRequest);
        userRepository.save(user);
    }

    public void login(UserLoginRequest userLoginRequest) {

    }

    public void logout() {

    }

    public UserResponse getProfile() {
        return null;
    }

    public void updateProfile(UserUpdateRequest userUpdateRequest) {

    }

    public void deleteProfile() {

    }
}
