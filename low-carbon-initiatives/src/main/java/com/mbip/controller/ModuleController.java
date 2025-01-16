package com.mbip.controller;

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
    public String submitWasteData(@RequestParam String username, @RequestParam double wasteProduced) {
        moduleService.submitWasteData(username, wasteProduced);
        return "Waste data submitted successfully";
    }

    @GetMapping("/waste")
    public List<?> getWasteReports(@RequestParam String username) {
        return moduleService.getWasteReports(username);
    }

    // Similarly, add endpoints for other modules
    @PostMapping("/water")
    public String submitWaterData(@RequestParam String username, @RequestParam double waterUsed) {
        moduleService.submitWaterData(username, waterUsed);
        return "Water data submitted successfully";
    }

    @PostMapping("/car")
    public String submitCarData(@RequestParam String username, @RequestParam double distanceDriven,
                                 @RequestParam double fuelEfficiency) {
        moduleService.submitCarData(username, distanceDriven, fuelEfficiency);
        return "Car data submitted successfully";
    }

    @PostMapping("/electricity")
    public String submitElectricityData(@RequestParam String username, @RequestParam double electricityUsed) {
        moduleService.submitElectricityData(username, electricityUsed);
        return "Electricity data submitted successfully";
    }

    // Overall Carbon Consumption Report
    @GetMapping("/overall")
    public double getOverallReport(@RequestParam String username) {
        return moduleService.getOverallCarbonReport(username);
    }
}
