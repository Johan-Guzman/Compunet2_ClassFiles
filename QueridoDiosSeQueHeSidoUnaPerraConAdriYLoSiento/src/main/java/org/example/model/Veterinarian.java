package org.example.model;

import java.util.ArrayList;
import java.util.Objects;

public class Veterinarian {
    private String id;
    private String name;
    private String licenseNumber;
    private String speciality;

    private ArrayList<Pet> pets;


    public Veterinarian(String id, String name, String licenseNumber, String speciality) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.speciality = speciality;
        this.pets = new ArrayList<>();
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veterinarian)) return false;
        Veterinarian that = (Veterinarian) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() { return Objects.hash(id); }
}
