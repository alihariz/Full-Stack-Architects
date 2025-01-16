package com.mbip.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.WasteManagement;

public interface WasteManagementRepository extends JpaRepository<WasteManagement, Long> {
    List<WasteManagement> findByUsername(String username);
    List<WasteManagement> findByUsernameAndSubmissionDateBetween(String username, LocalDate startDate, LocalDate endDate);
}
