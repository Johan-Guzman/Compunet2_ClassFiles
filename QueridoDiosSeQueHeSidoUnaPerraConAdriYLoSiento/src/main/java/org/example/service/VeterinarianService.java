package org.example.service;

import org.example.model.Veterinarian;
import org.example.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    // Agregar veterinario validando la regla de negocio
    public void addVet(Veterinarian veterinarian) {
        // Regla: no se puede agregar dos con el mismo número de colegiado
        Veterinarian found = veterinarianRepository.getByLicenseNumber(veterinarian.getLicenseNumber());
        if (found == null) {
            veterinarianRepository.addVet(veterinarian); // aquí sí guardamos en repo
        } else {
            System.out.println("Vet already exists with license: " + veterinarian.getLicenseNumber());
        }
    }

    // Verificar existencia comparando por licenseNumber
    public boolean existsVet(Veterinarian veterinarian) {
        Veterinarian found = veterinarianRepository.getByLicenseNumber(veterinarian.getLicenseNumber());
        return found != null;
    }

    public ArrayList<Veterinarian> getVets() {
        if(veterinarianRepository.getVets()!=null){
            return veterinarianRepository.getVets();
        }
        return null;
    }
}
