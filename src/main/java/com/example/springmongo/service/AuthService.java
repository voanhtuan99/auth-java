package com.example.springmongo.service;

import com.example.springmongo.model.User;
import com.example.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public User signUp (User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
}
