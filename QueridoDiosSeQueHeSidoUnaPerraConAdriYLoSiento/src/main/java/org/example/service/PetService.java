package org.example.service;

import org.example.model.Pet;
import org.example.model.Veterinarian;
import org.example.repository.PetRepository;
import org.example.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    // Agregar mascota validando que exista el veterinario asignado
    public void addPet(Pet pet) {
        Veterinarian vet = veterinarianRepository.getById(pet.getVetId());
        if (vet != null) {
            petRepository.addPet(pet);
        } else {
            System.out.println("Cannot add pet, veterinarian not found with id: " + pet.getVetId());
        }
    }

    // Ver todas las mascotas
    public ArrayList<Pet> getPets() {
        return petRepository.getPets();
    }

    // Ver todas las mascotas de un veterinario
    public ArrayList<Pet> getPetsByVet(String veterinarianId) {
        return petRepository.getByVeterinarianId(veterinarianId);
    }


}
