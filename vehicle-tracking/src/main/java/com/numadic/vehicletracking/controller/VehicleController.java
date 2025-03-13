package com.numadic.vehicletracking.controller;

import com.numadic.vehicletracking.model.Vehicle;
import com.numadic.vehicletracking.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
//@RequestMapping("/api/vehicles")

@CrossOrigin(origins = "*")

public class VehicleController {

	 private final VehicleService vehicleService;

	    @Autowired
	    public VehicleController(VehicleService vehicleService) {
	        this.vehicleService = vehicleService;
	    }

	    // Get all vehicles
	    @GetMapping
	    public List<Vehicle> getAllVehicles() {
	        return vehicleService.getAllVehicles();
	    }

	    // Get a vehicle by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
	        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
	        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Get a vehicle by vehicle number
	    @GetMapping("/vehicleNumber/{vehicleNumber}")
	    public ResponseEntity<Vehicle> getVehicleByVehicleNumber(@PathVariable String vehicleNumber) {
	        Optional<Vehicle> vehicle = vehicleService.getVehicleByVehicleNumber(vehicleNumber);
	        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Add a new vehicle or update an existing one
	    @PostMapping
	    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
	        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
	    }

	    // Update an existing vehicle
	    @PutMapping("/{id}")
	    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
	        if (!vehicleService.getVehicleById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        vehicle.setId(id); // Ensure the vehicle ID is set correctly
	        Vehicle updatedVehicle = vehicleService.saveVehicle(vehicle);
	        return ResponseEntity.ok(updatedVehicle);
	    }

	    // Delete a vehicle by ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
	        if (!vehicleService.getVehicleById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        vehicleService.deleteVehicle(id);
	        return ResponseEntity.noContent().build();
	    }
}
