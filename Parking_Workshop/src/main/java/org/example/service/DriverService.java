package org.example.service;


import org.example.model.Driver;
import org.example.repository.DriverRepository;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    public void addDriver(Driver driver) {
        if (driverRepository.getDrivers().contains(driver)) {
            System.out.println("Driver already exists");

        } else {
            driverRepository.addDriver(driver);
        }
    }

       public ArrayList<Driver> getDrivers(){
            return driverRepository.getDrivers();
        }


        public void initRepository() {
        driverRepository.initRepo();
        }


}
