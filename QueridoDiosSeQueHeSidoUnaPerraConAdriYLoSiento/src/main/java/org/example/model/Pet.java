package org.example.model;

public class Pet {
    private String name;
    private String birthDate;
    private String type;
    private String vetId;


    public Pet(String name, String birthDate, String type, String vetId) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.vetId = vetId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }
}
