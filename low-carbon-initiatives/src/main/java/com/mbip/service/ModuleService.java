package com.mbip.service;

import com.mbip.model.*;
import com.mbip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private WasteManagementRepository wasteRepo;
    @Autowired
    private WaterConsumptionRepository waterRepo;
    @Autowired
    private CarEmissionsRepository carRepo;
    @Autowired
    private ElectricalConsumptionRepository electricalRepo;

    // Waste Management
    public void submitWasteData(String username, double wasteProduced) {
        double carbonEmissions = wasteProduced * 2.0; // Example formula
        WasteManagement waste = new WasteManagement();
        waste.setUsername(username);
        waste.setWasteProduced(wasteProduced);
        waste.setCarbonEmissions(carbonEmissions);
        wasteRepo.save(waste);
    }

    public List<WasteManagement> getWasteReports(String username) {
        return (List<WasteManagement>) wasteRepo.findByUsername(username); // Explicit cast
    }

    // Water Consumption
    public void submitWaterData(String username, double waterUsed) {
        double carbonEmissions = waterUsed * 0.5; // Example formula
        WaterConsumption water = new WaterConsumption();
        water.setUsername(username);
        water.setWaterUsed(waterUsed);
        water.setCarbonEmissions(carbonEmissions);
        waterRepo.save(water);
    }

    public List<WaterConsumption> getWaterReports(String username) {
        return (List<WaterConsumption>) waterRepo.findByUsername(username); // Explicit cast
    }

    // Car Emissions
    public void submitCarData(String username, double distanceDriven, double fuelEfficiency) {
        double carbonEmissions = (distanceDriven / fuelEfficiency) * 2.3; // Example formula
        CarEmissions car = new CarEmissions();
        car.setUsername(username);
        car.setDistanceDriven(distanceDriven);
        car.setFuelEfficiency(fuelEfficiency);
        car.setCarbonEmissions(carbonEmissions);
        carRepo.save(car);
    }

    public List<CarEmissions> getCarReports(String username) {
        return (List<CarEmissions>) carRepo.findByUsername(username); // Explicit cast
    }

    // Electrical Consumption
    public void submitElectricityData(String username, double electricityUsed) {
        double carbonEmissions = electricityUsed * 0.7; // Example formula
        ElectricalConsumption electrical = new ElectricalConsumption();
        electrical.setUsername(username);
        electrical.setElectricityUsed(electricityUsed);
        electrical.setCarbonEmissions(carbonEmissions);
        electricalRepo.save(electrical);
    }

    public List<ElectricalConsumption> getElectricalReports(String username) {
        return (List<ElectricalConsumption>) electricalRepo.findByUsername(username); // Explicit cast
    }

    // Overall Carbon Report
    public double getOverallCarbonReport(String username) {
        double waste = wasteRepo.findByUsername(username)
                .stream()
                .mapToDouble(data -> ((WasteManagement) data).getCarbonEmissions()) // Explicit cast
                .sum();
        double water = waterRepo.findByUsername(username)
                .stream()
                .mapToDouble(data -> ((WaterConsumption) data).getCarbonEmissions()) // Explicit cast
                .sum();
        double car = carRepo.findByUsername(username)
                .stream()
                .mapToDouble(data -> ((CarEmissions) data).getCarbonEmissions()) // Explicit cast
                .sum();
        double electrical = electricalRepo.findByUsername(username)
                .stream()
                .mapToDouble(data -> ((ElectricalConsumption) data).getCarbonEmissions()) // Explicit cast
                .sum();
        return waste + water + car + electrical;
    }
}
