package com.numadic.vehicletracking.repository;

import com.numadic.vehicletracking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
     
}
