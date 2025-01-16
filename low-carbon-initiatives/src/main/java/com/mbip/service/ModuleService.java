package com.mbip.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbip.model.CarEmissions;
import com.mbip.model.ElectricalConsumption;
import com.mbip.model.WasteManagement;
import com.mbip.model.WaterConsumption;
import com.mbip.repository.CarEmissionsRepository;
import com.mbip.repository.ElectricalConsumptionRepository;
import com.mbip.repository.WasteManagementRepository;
import com.mbip.repository.WaterConsumptionRepository;

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
    public void submitWasteData(String username, double wasteProduced, LocalDate submissionDate) {
        double carbonEmissions = wasteProduced * 2.0; // Example formula
        WasteManagement waste = new WasteManagement();
        waste.setUsername(username);
        waste.setWasteProduced(wasteProduced);
        waste.setCarbonEmissions(carbonEmissions);
        waste.setSubmissionDate(submissionDate);
        wasteRepo.save(waste);
    }

    public List<WasteManagement> getWasteReports(String username) {
        return wasteRepo.findByUsername(username);
    }

    public double getMonthlyWasteCarbonEmissions(String username) {
        YearMonth currentMonth = YearMonth.now();
        LocalDate startDate = currentMonth.atDay(1);
        LocalDate endDate = currentMonth.atEndOfMonth();
        return wasteRepo.findByUsernameAndSubmissionDateBetween(username, startDate, endDate)
                .stream()
                .mapToDouble(WasteManagement::getCarbonEmissions)
                .sum();
    }

    // Water Consumption
    public void submitWaterData(String username, double waterUsed, LocalDate submissionDate) {
        double carbonEmissions = waterUsed * 0.5; // Example formula
        WaterConsumption water = new WaterConsumption();
        water.setUsername(username);
        water.setWaterUsed(waterUsed);
        water.setCarbonEmissions(carbonEmissions);
        water.setSubmissionDate(submissionDate);
        waterRepo.save(water);
    }

    public List<WaterConsumption> getWaterReports(String username) {
        return waterRepo.findByUsername(username);
    }

    public double getMonthlyWaterCarbonEmissions(String username) {
        YearMonth currentMonth = YearMonth.now();
        LocalDate startDate = currentMonth.atDay(1);
        LocalDate endDate = currentMonth.atEndOfMonth();
        return waterRepo.findByUsernameAndSubmissionDateBetween(username, startDate, endDate)
                .stream()
                .mapToDouble(WaterConsumption::getCarbonEmissions)
                .sum();
    }

    // Car Emissions
    public void submitCarData(String username, double distanceDriven, double fuelEfficiency, LocalDate submissionDate) {
        double carbonEmissions = (distanceDriven / fuelEfficiency) * 2.3; // Example formula
        CarEmissions car = new CarEmissions();
        car.setUsername(username);
        car.setDistanceDriven(distanceDriven);
        car.setFuelEfficiency(fuelEfficiency);
        car.setCarbonEmissions(carbonEmissions);
        car.setSubmissionDate(submissionDate);
        carRepo.save(car);
    }

    public List<CarEmissions> getCarReports(String username) {
        return carRepo.findByUsername(username);
    }

    public double getMonthlyCarCarbonEmissions(String username) {
        YearMonth currentMonth = YearMonth.now();
        LocalDate startDate = currentMonth.atDay(1);
        LocalDate endDate = currentMonth.atEndOfMonth();
        return carRepo.findByUsernameAndSubmissionDateBetween(username, startDate, endDate)
                .stream()
                .mapToDouble(CarEmissions::getCarbonEmissions)
                .sum();
    }

    // Electrical Consumption
    public void submitElectricityData(String username, double electricityUsed, LocalDate submissionDate) {
        double carbonEmissions = electricityUsed * 0.7; // Example formula
        ElectricalConsumption electrical = new ElectricalConsumption();
        electrical.setUsername(username);
        electrical.setElectricityUsed(electricityUsed);
        electrical.setCarbonEmissions(carbonEmissions);
        electrical.setSubmissionDate(submissionDate);
        electricalRepo.save(electrical);
    }

    public List<ElectricalConsumption> getElectricalReports(String username) {
        return electricalRepo.findByUsername(username);
    }

    public double getMonthlyElectricalCarbonEmissions(String username) {
        YearMonth currentMonth = YearMonth.now();
        LocalDate startDate = currentMonth.atDay(1);
        LocalDate endDate = currentMonth.atEndOfMonth();
        return electricalRepo.findByUsernameAndSubmissionDateBetween(username, startDate, endDate)
                .stream()
                .mapToDouble(ElectricalConsumption::getCarbonEmissions)
                .sum();
    }

    // Overall Carbon Report
    public double getOverallCarbonReport(String username) {
        double waste = getMonthlyWasteCarbonEmissions(username);
        double water = getMonthlyWaterCarbonEmissions(username);
        double car = getMonthlyCarCarbonEmissions(username);
        double electrical = getMonthlyElectricalCarbonEmissions(username);
        return waste + water + car + electrical;
    }
}
