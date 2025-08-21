package org.example.repository;

import org.example.model.Veterinarian;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class VeterinarianRepository {

    // Lista en memoria para guardar los veterinarios
    ArrayList<Veterinarian> veterinarians = new ArrayList<Veterinarian>();

    // Agregar veterinario
    public void addVet(Veterinarian vet) {
        veterinarians.add(vet);
    }

    // Devolver todos
    public ArrayList<Veterinarian> getVets() {
        return veterinarians;
    }

    // Buscar por id (devuelve null si no existe)
    public Veterinarian getById(String id) {
        for (Veterinarian v : veterinarians) {
            if (v.getId() != null && v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    // Buscar por número de colegiado (devuelve null si no existe)
    public Veterinarian getByLicenseNumber(String licenseNumber) {
        for (Veterinarian v : veterinarians) {
            if (v.getLicenseNumber() != null && v.getLicenseNumber().equals(licenseNumber)) {
                return v;
            }
        }
        return null;
    }
}
