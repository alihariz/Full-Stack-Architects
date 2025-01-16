package com.mbip.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.ElectricalConsumption;

public interface ElectricalConsumptionRepository extends JpaRepository<ElectricalConsumption, Long> {
    List<ElectricalConsumption> findByUsername(String username);
    List<ElectricalConsumption> findByUsernameAndSubmissionDateBetween(String username, LocalDate startDate, LocalDate endDate);
}
