package com.mbip.controller;

import com.mbip.model.User;
import com.mbip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User authenticatedUser = userService.authenticateUser(username, password);
        if (authenticatedUser != null) {
            return ResponseEntity.ok("Login successful for user: " + authenticatedUser.getRole());
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
