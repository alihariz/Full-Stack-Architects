// WaterConsumptionRepository.java
package com.mbip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.WaterConsumption;

public interface WaterConsumptionRepository extends JpaRepository<WaterConsumption, Long> {
    List<WaterConsumption> findByUsername(String username);
}