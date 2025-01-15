package com.mbip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {

    @GetMapping("/dashboard")
        public String dashboard(HttpSession session, Model model) {
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            System.out.println("Username: " + username);
            System.out.println("Role: " + role);

            if (username == null || role == null) {
                return "redirect:/login";
            }

            model.addAttribute("username", username);
            if (role.equals("PARTICIPANT")) {
                return "dashboard_participant";
            } else if (role.equals("MBIP")) {
                return "dashboard_mbip";
            }

            return "error";
        }

    @GetMapping("/login")
    public String login() {
        return "login"; // Show the login.jsp
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clear the session
        return "redirect:/login";
    }
}
