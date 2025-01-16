package com.mbip.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbip.service.ModuleService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Waste Management
    @PostMapping("/waste")
    public String submitWasteData(@RequestParam double wasteProduced,
                                  @RequestParam String submissionDate,
                                  HttpSession session) {
        String username = (String) session.getAttribute("username");
        moduleService.submitWasteData(username, wasteProduced, LocalDate.parse(submissionDate));
        return "Waste data submitted successfully";
    }

    @GetMapping("/waste/summary")
    public double getMonthlyWasteSummary(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return moduleService.getMonthlyWasteCarbonEmissions(username);
    }

    // Water Consumption
    @PostMapping("/water")
    public String submitWaterData(@RequestParam double waterUsed,
                                  @RequestParam String submissionDate,
                                  HttpSession session) {
        String username = (String) session.getAttribute("username");
        moduleService.submitWaterData(username, waterUsed, LocalDate.parse(submissionDate));
        return "Water data submitted successfully";
    }

    @GetMapping("/water/summary")
    public double getMonthlyWaterSummary(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return moduleService.getMonthlyWaterCarbonEmissions(username);
    }

    // Car Emissions
    @PostMapping("/car")
    public String submitCarData(@RequestParam double distanceDriven,
                                 @RequestParam double fuelEfficiency,
                                 @RequestParam String submissionDate,
                                 HttpSession session) {
        String username = (String) session.getAttribute("username");
        moduleService.submitCarData(username, distanceDriven, fuelEfficiency, LocalDate.parse(submissionDate));
        return "Car data submitted successfully";
    }

    @GetMapping("/car/summary")
    public double getMonthlyCarSummary(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return moduleService.getMonthlyCarCarbonEmissions(username);
    }

    // Electrical Consumption
    @PostMapping("/electricity")
    public String submitElectricityData(@RequestParam double electricityUsed,
                                        @RequestParam String submissionDate,
                                        HttpSession session) {
        String username = (String) session.getAttribute("username");
        moduleService.submitElectricityData(username, electricityUsed, LocalDate.parse(submissionDate));
        return "Electricity data submitted successfully";
    }

    @GetMapping("/electricity/summary")
    public double getMonthlyElectricitySummary(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return moduleService.getMonthlyElectricalCarbonEmissions(username);
    }

    // Overall Carbon Consumption Report
    @GetMapping("/overall")
    public double getOverallReport(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return moduleService.getOverallCarbonReport(username);
    }
}
