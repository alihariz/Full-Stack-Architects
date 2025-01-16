package com.mbip.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbip.service.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Waste Management
    @PostMapping("/waste")
    public String submitWasteData(@RequestParam String username,
                                  @RequestParam double wasteProduced,
                                  @RequestParam String submissionDate) {
        moduleService.submitWasteData(username, wasteProduced, LocalDate.parse(submissionDate));
        return "Waste data submitted successfully";
    }

    @GetMapping("/waste")
    public List<?> getWasteReports(@RequestParam String username) {
        return moduleService.getWasteReports(username);
    }

    @GetMapping("/waste/summary")
    public double getMonthlyWasteSummary(@RequestParam String username) {
        return moduleService.getMonthlyWasteCarbonEmissions(username);
    }

    // Water Consumption
    @PostMapping("/water")
    public String submitWaterData(@RequestParam String username,
                                  @RequestParam double waterUsed,
                                  @RequestParam String submissionDate) {
        moduleService.submitWaterData(username, waterUsed, LocalDate.parse(submissionDate));
        return "Water data submitted successfully";
    }

    @GetMapping("/water")
    public List<?> getWaterReports(@RequestParam String username) {
        return moduleService.getWaterReports(username);
    }

    @GetMapping("/water/summary")
    public double getMonthlyWaterSummary(@RequestParam String username) {
        return moduleService.getMonthlyWaterCarbonEmissions(username);
    }

    // Car Emissions
    @PostMapping("/car")
    public String submitCarData(@RequestParam String username,
                                 @RequestParam double distanceDriven,
                                 @RequestParam double fuelEfficiency,
                                 @RequestParam String submissionDate) {
        moduleService.submitCarData(username, distanceDriven, fuelEfficiency, LocalDate.parse(submissionDate));
        return "Car data submitted successfully";
    }

    @GetMapping("/car")
    public List<?> getCarReports(@RequestParam String username) {
        return moduleService.getCarReports(username);
    }

    @GetMapping("/car/summary")
    public double getMonthlyCarSummary(@RequestParam String username) {
        return moduleService.getMonthlyCarCarbonEmissions(username);
    }

    // Electrical Consumption
    @PostMapping("/electricity")
    public String submitElectricityData(@RequestParam String username,
                                        @RequestParam double electricityUsed,
                                        @RequestParam String submissionDate) {
        moduleService.submitElectricityData(username, electricityUsed, LocalDate.parse(submissionDate));
        return "Electricity data submitted successfully";
    }

    @GetMapping("/electricity")
    public List<?> getElectricityReports(@RequestParam String username) {
        return moduleService.getElectricalReports(username);
    }

    @GetMapping("/electricity/summary")
    public double getMonthlyElectricitySummary(@RequestParam String username) {
        return moduleService.getMonthlyElectricalCarbonEmissions(username);
    }

    // Overall Carbon Consumption Report
    @GetMapping("/overall")
    public double getOverallReport(@RequestParam String username) {
        return moduleService.getOverallCarbonReport(username);
    }
}
