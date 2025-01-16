// CarEmissions.java
package com.mbip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CarEmissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private double distanceDriven; // in km
    private double fuelEfficiency; // in km/l
    private double carbonEmissions; // calculated value
}