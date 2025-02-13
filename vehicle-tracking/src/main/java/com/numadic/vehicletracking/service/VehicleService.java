package com.numadic.vehicletracking.service;

import com.numadic.vehicletracking.model.Vehicle;
import com.numadic.vehicletracking.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
	 private final VehicleRepository vehicleRepository;

	    @Autowired
	    public VehicleService(VehicleRepository vehicleRepository) {
	        this.vehicleRepository = vehicleRepository;
	    }

	    // Create or update a vehicle
	    public Vehicle saveVehicle(Vehicle vehicle) {
	        return vehicleRepository.save(vehicle);
	    }

	    // Get vehicle by ID
	    public Optional<Vehicle> getVehicleById(Long id) {
	        return vehicleRepository.findById(id);
	    }

	    // Get vehicle by vehicle number
	    public Optional<Vehicle> getVehicleByVehicleNumber(String vehicleNumber) {
	        return vehicleRepository.findByVehicleNumber(vehicleNumber);
	    }

	    // Get all vehicles
	    public List<Vehicle> getAllVehicles() {
	        return vehicleRepository.findAll();
	    }

	    // Delete vehicle by ID
	    public void deleteVehicle(Long id) {
	        vehicleRepository.deleteById(id);
	    }



	
}

