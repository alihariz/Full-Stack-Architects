package com.mbip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbip.model.User;
import com.mbip.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
        @RequestParam("username") String username, 
        @RequestParam("password") String password, 
        @RequestParam("role") String role) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            userService.registerUser(user);
            return ResponseEntity.status(302).header("Location", "/login").body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to register. Please try again.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username, 
                                         @RequestParam("password") String password, 
                                         HttpSession session) {
        User authenticatedUser = userService.authenticateUser(username, password);
        if (authenticatedUser != null) {
            session.setAttribute("username", authenticatedUser.getUsername());
            session.setAttribute("role", authenticatedUser.getRole());
            if ("MBIP".equals(authenticatedUser.getRole())) {
                return ResponseEntity.status(302).header("Location", "/dashboard-mbip").body("Redirecting to MBIP dashboard");
            } else {
                return ResponseEntity.status(302).header("Location", "/dashboard-participant").body("Redirecting to participant dashboard");
            }
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
