package org.example.repository;

import org.example.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PetRepository {

    // Lista en memoria para guardar las mascotas
    ArrayList<Pet> pets = new ArrayList<Pet>();

    // Agregar mascota
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    // Ver todas las mascotas
    public ArrayList<Pet> getPets() {
        return pets;
    }

    // Buscar mascotas por id de veterinario (relación uno a muchos)
    public ArrayList<Pet> getByVeterinarianId(String veterinarianId) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            Pet p = pets.get(i);
            if (p.getVetId() != null && p.getVetId().equals(veterinarianId)) {
                result.add(p);
            }
        }
        return result;
    }


}
