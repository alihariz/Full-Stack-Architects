package com.mbip.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.WaterConsumption;

public interface WaterConsumptionRepository extends JpaRepository<WaterConsumption, Long> {
    List<WaterConsumption> findByUsername(String username);
    List<WaterConsumption> findByUsernameAndSubmissionDateBetween(String username, LocalDate startDate, LocalDate endDate);
}
