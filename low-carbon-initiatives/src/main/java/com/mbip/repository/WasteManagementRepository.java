package com.mbip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.WasteManagement;

public interface WasteManagementRepository extends JpaRepository<WasteManagement, Long> {

    // Ensure this method returns List<WasteManagement>
    List<WasteManagement> findByUsername(String username);
}
