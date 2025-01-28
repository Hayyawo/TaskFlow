package com.example.taskflow.service;

import com.example.taskflow.config.JwtUtil;

import com.example.taskflow.mapper.UserMapper;
import com.example.taskflow.model.User;
import com.example.taskflow.model.dto.UserLoginRequest;
import com.example.taskflow.model.dto.UserRegisterRequest;
import com.example.taskflow.model.dto.UserResponse;
import com.example.taskflow.model.dto.UserUpdateRequest;
import com.example.taskflow.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;
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

    public String register(UserRegisterRequest userRequest) {
        if (userRepository.findByUsername(userRequest.username()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = UserMapper.map(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return jwtUtil.generateToken(user.getUsername());
    }

    public String login(UserLoginRequest userLoginRequest) {
        Optional<User> user = userRepository.findByUsername(userLoginRequest.username());
        if (user.isEmpty() || !((Objects.equals(userLoginRequest.password(), user.get().getPassword())))) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        return jwtUtil.generateToken(user.get().getUsername());
    }

    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    public UserResponse getProfile(String username) {
        return UserMapper.map(userRepository.findByUsername(username).orElseThrow());
    }

    public void updateProfile(UserUpdateRequest userUpdateRequest) {
        userRepository.save(UserMapper.map(userUpdateRequest));
    }

    public void deleteProfile(String username) {
        userRepository.deleteUserByUsername(username);
    }
}
