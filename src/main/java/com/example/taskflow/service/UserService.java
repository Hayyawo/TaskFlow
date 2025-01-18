package com.example.taskflow.service;

import com.example.taskflow.config.JwtUtil;

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
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(UserRegisterRequest userRequest) {
        if (userRepository.findByUsername(userRequest.username()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = UserMapper.map(userRequest);
        userRepository.save(user);
    }

    public String login(UserLoginRequest userLoginRequest) {
        Optional<User> user = userRepository.findByUsername(userLoginRequest.username());
        if (user.isEmpty() || !passwordEncoder.matches(userLoginRequest.password(), user.get().getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        return jwtUtil.generateToken(user.get().getUsername());
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
