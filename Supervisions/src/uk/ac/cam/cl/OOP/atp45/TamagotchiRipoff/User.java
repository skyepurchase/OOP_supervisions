package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;

public class User {
    private final String username;
    private final int id;
    private ArrayList<Pet> pets = new ArrayList<>();

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public void update(int hours_passed) {
        ArrayList<Pet> dead_pets = new ArrayList<>();

        for (Pet pet : pets) {
            pet.update(hours_passed);

            if (pet.isDead()) {
                dead_pets.add(pet);
            }
        }

        for (Pet pet : dead_pets){
            pets.remove(pet);
        }
    }

    public void newYear() {
        for (Pet pet : pets) {
            pet.newYear();
        }
    }

    public void newDay() {
        for (Pet pet : pets) {
            pet.newDay();
        }
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public String getUsername() {
        return username;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public boolean hasPets() {
        return pets.size() > 0;
    }
}
