package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Pet> pets = new ArrayList<>();

    public Shop() {
        pets.add(new Cat("Muffles", 'f', 2, 4, 4));
        pets.add(new Cat("Toothless", 'f', 4, 3, 2));
        pets.add(new Cat("Puff", 'm', 2, 2, 2));
        pets.add(new Dog("Sasha", 'm', 2, 4, 1));
        pets.add(new Dog("Talisker", 'm', 5, 2, 1));
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void buyPet(Pet pet) {
        pets.remove(pet);
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
            pets.add(new Cat("No name", 'f', 2, 2, 2)); // Just gonna female cats
        }
    }

    public void newYear() {
        for (Pet pet : pets) {
            pet.newYear();
        }
    }
}
