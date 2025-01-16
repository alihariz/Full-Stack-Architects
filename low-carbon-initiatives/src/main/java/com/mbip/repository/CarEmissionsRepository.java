package com.mbip.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.CarEmissions;

public interface CarEmissionsRepository extends JpaRepository<CarEmissions, Long> {
    List<CarEmissions> findByUsername(String username);
    List<CarEmissions> findByUsernameAndSubmissionDateBetween(String username, LocalDate startDate, LocalDate endDate);
}
