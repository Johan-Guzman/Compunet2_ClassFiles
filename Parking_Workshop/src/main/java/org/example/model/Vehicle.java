package org.example.model;

public class Vehicle {
    private String id;
    private String placa;
    private String cilindraje;
    private String typeFuel;
    private String numberMotor;
    private String brand;
    private String model;
    private String conductorId; // Referencia al conductor



    public Vehicle(String id, String placa, String cilindraje, String typeFuel,
                   String numberMotor, String brand, String model, String conductorId) {
        this.id = id;
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.typeFuel = typeFuel;
        this.numberMotor = numberMotor;
        this.brand = brand;
        this.model = model;
        this.conductorId = conductorId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberMotor() {
        return numberMotor;
    }

    public void setNumberMotor(String numberMotor) {
        this.numberMotor = numberMotor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }
}
