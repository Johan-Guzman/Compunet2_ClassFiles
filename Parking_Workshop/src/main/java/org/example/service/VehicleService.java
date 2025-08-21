package org.example.service;
import org.example.model.Vehicle;
import org.example.repository.DriverRepository;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private DriverRepository driverRepository;



    public void addVehicle(Vehicle vehicle) {
        if(vehicleRepository.getVehicles().contains(vehicle)) {
            System.out.println("Vehicle already exists");
        }else {
            vehicleRepository.addVehicle(vehicle);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    public void initRepository() {
        vehicleRepository.initRepo();
    }
}
