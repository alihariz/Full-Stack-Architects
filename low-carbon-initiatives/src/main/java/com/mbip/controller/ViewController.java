package com.mbip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {

    @GetMapping("/")
    public String redirectToLoginOrDashboard(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        if (username != null && role != null) {
            if ("MBIP".equals(role)) {
                return "redirect:/dashboard-mbip";
            } else if ("PARTICIPANT".equals(role)) {
                return "redirect:/dashboard-participant";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/dashboard-mbip")
    public String mbipDashboard(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "dashboard_mbip";
    }

    @GetMapping("/dashboard-participant")
    public String participantDashboard(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "dashboard_participant";
    }

    // Module Pages
    @GetMapping("/waste_management")
    public String wasteManagementPage() {
        return "waste_management"; // Maps to /WEB-INF/jsp/waste_management.jsp
    }

    @GetMapping("/water_consumption")
    public String waterConsumptionPage() {
        return "water_consumption"; // Maps to /WEB-INF/jsp/water_consumption.jsp
    }

    @GetMapping("/car_emissions")
    public String carEmissionsPage() {
        return "car_emissions"; // Maps to /WEB-INF/jsp/car_emissions.jsp
    }

    @GetMapping("/electrical_consumption")
    public String electricalConsumptionPage() {
        return "electrical_consumption"; // Maps to /WEB-INF/jsp/electrical_consumption.jsp
    }
}
