package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;

class Shop {
    private ArrayList<Pet> pets = new ArrayList<>();

    Shop() {
        pets.add(new Cat("Muffles", 'f', 2, 4, 4));
        pets.add(new Cat("Toothless", 'f', 4, 3, 2));
        pets.add(new Cat("Puff", 'm', 2, 2, 2));
        pets.add(new Dog("Sasha", 'm', 2, 4, 1));
        pets.add(new Dog("Talisker", 'm', 5, 2, 1));
    }

    ArrayList<Pet> getPets() {
        return pets;
    }

    void buyPet(Pet pet) {
        pets.remove(pet);
    }

    void update(int hours_passed, int delta_t) {
        int dead_animals = 0;
        for (Pet pet : pets) {
            pet.update(hours_passed);

            if(pet.isDead()) {
                dead_animals++;
            }
        }

        for (int i = 0; i < dead_animals; i++){
            pets.add(new Cat("No name", 'f', 2, 2, 2)); // Just gonna female cats
        }
    }

    void newYear() {
        for (Pet pet : pets) {
            pet.newYear();
        }
    }
}
