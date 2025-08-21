package org.example.repository;


import org.example.model.Driver;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;



import java.util.ArrayList;

@Repository
public class DriverRepository {
    ArrayList<Driver> drivers = new ArrayList<>();


    @PostConstruct
    public void initRepo(){

        drivers.add(new Driver("001","Adri","001","Moza", "CC"));
        drivers.add(new Driver("002","Adri","002","Moza", "CC"));
        drivers.add(new Driver("003","Adri","003","Moza", "CC"));

    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }



}
