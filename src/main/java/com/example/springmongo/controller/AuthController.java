package com.example.springmongo.controller;

import com.example.springmongo.model.User;
import com.example.springmongo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auths")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("")
    public ResponseEntity<User> register (@RequestBody User user) {
        User userRes = authService.signUp(user);
        System.out.println(userRes);
        return ResponseEntity.ok(userRes);
    }
}
