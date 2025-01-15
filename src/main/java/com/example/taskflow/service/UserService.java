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

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterRequest userRequest) {
        if (userRepository.findByUsername(userRequest.username()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = UserMapper.map(userRequest);
        userRepository.save(user);
    }

    public void login(UserLoginRequest userLoginRequest) {
        Optional<User> userOpt = userRepository.findByUsername(userLoginRequest.username());
        if (userOpt.isEmpty() || !passwordEncoder.matches(userLoginRequest.password(), userOpt.get().getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        // Handle login logic, e.g., issue a JWT token (if needed)
    }

    public void logout() {
        // Handle logout logic (if session-based authentication is used)
    }

    public UserResponse getProfile() {
        // Fetch and return the currently logged-in user's profile
//        return new UserResponse(/* populate with user data */);
        return null;
    }

    public void updateProfile(UserUpdateRequest userUpdateRequest) {
        // Update the current user's profile
    }

    public void deleteProfile() {
        // Delete the current user's profile
    }
}
