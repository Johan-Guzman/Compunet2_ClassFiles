package org.example.repository;


import org.example.model.Vehicle;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Repository
public class VehicleRepository {

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    @PostConstruct
    public void initRepo(){

        vehicles.add(new Vehicle("001", "MIL295","100","GAS","002","HONDA","2020","001"));
        vehicles.add(new Vehicle("002", "MIL295","100","GAS","002","HONDA","2020","002"));
        vehicles.add(new Vehicle("003", "MIL295","100","GAS","002","HONDA","2020","003"));

    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }



}
