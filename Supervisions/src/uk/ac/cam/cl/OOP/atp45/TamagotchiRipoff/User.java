package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;

class User {
    private final String username;
    private final int id;
    private ArrayList<Pet> pets = new ArrayList<>();

    User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    void update(int days_passed, int delta_t) {
        for (Pet pet : pets) {
            pet.update(days_passed);
        }
    }

    void newYear() {
        for (Pet pet : pets) {
            pet.newYear();
        }
    }

    ArrayList<Pet> getPets() {
        return pets;
    }

    String getUsername() {
        return username;
    }

    void addPet(Pet pet) {
        pets.add(pet);
    }
}
