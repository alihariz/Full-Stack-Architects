// CarEmissionsRepository.java
package com.mbip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbip.model.CarEmissions;

public interface CarEmissionsRepository extends JpaRepository<CarEmissions, Long> {
    List<CarEmissions> findByUsername(String username);
}