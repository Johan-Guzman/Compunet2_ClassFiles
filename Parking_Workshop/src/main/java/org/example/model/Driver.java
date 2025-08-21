package org.example.model;

import java.util.ArrayList;

public class Driver {

    private String id;
    private String name;
    private String occupation;
    private String typeId;
    private String numberIdentification;

    private ArrayList<Vehicle> vehicles;//Aqui creo pa poder guardar. NO SE TE PUEDE OLVIDAR HACER ESTO



    public Driver(String id, String name, String numberIdentification, String occupation, String typeId) {
        this.id = id;
        this.name = name;
        this.numberIdentification = numberIdentification;
        this.occupation = occupation;
        this.typeId = typeId;
        this.vehicles = new ArrayList<>();//Aqui creo pa poder guardar. NO SE TE PUEDE OLVIDAR HACER ESTO
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(String numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
