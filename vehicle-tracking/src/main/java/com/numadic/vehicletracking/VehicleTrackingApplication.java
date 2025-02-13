package com.numadic.vehicletracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.numadic.vehicletracking")
public class VehicleTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleTrackingApplication.class, args);
	}

}
