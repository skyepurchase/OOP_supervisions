package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tomagotchi {
    private final ArrayList<User> users;
    private static final UI user_interface = TextUI.getInstance();
    private static final ArrayList<String> choices = new ArrayList<>(Arrays.asList(
            "1. See Pets",
            "2. Feed Pet",
            "3. Play with Pet",
            "4. Wake Pet",
            "5. Buy Pet",
            "6. Quit"
    ));
    private static int nextID;

    public Tomagotchi(String username) {
        this.users = new ArrayList<>(Collections.singletonList(new User(username, nextID)));
        nextID++;
    }

    public void start() throws InterruptedException {
        user_interface.displayMessage("Will get to choosing user later");
        run(users.get(0));
    }

    public void run(User user) throws InterruptedException {
        long start_time = System.currentTimeMillis();
        long current_time = 0;
        long previous_time = start_time;

        boolean playing = true;

        Shop shop = new Shop();

        while (playing) {
            current_time = System.currentTimeMillis();

            update(user, shop, current_time - previous_time, current_time - start_time);

            previous_time = current_time;

            user_interface.displayMenu(choices);

            int choice = getIntInput();
            if (choice == 6) {
                playing = false;
            } else if (choice == 1) {
                user_interface.displayPets(user.getPets());
            } else if (choice == 2) {
                feedPet(user);
            } else if (choice == 3) {
                playPet(user);
            } else if (choice == 4) {
                wakePet(user);
            } else if (choice == 5) {
                buyPet(user, shop);
            } else {
                user_interface.displayMessage("Invalid input! Input a number from 1-6!");
            }

            Thread.sleep(1000/60); // Update roughly 60 times a second
        }
    }

    private int getIntInput() {
        int choice = -1;
        try {
            choice = Integer.parseInt(user_interface.getInput());
        } catch(NumberFormatException e) {
            user_interface.displayMessage("Invalid input! Not a number!");
        }

        return choice;
    }

    private String getStrInput() {
        return user_interface.getInput();
    }

    private void newDay() {
        user_interface.displayMessage("It's a new day!");
    }

    private void feedPet(User user) {
        ArrayList<Pet> pets = user.getPets();
        int num_pets = user_interface.displayFeed(pets);

        int choice = getIntInput();

        while ((choice < 1) || (choice > num_pets)) {
            user_interface.displayMessage("Invalid input! Outside of range!");
            user_interface.displayFeed(pets);
            choice = getIntInput();
        }

        Pet pet = pets.get(choice - 1);
        pet.feed();
    }

    private void playPet(User user) {
        ArrayList<Pet> pets = user.getPets();
        int num_pets = user_interface.displayPlay(pets);

        int choice = getIntInput();

        while ((choice < 1) || (choice > num_pets)) {
            user_interface.displayMessage("Invalid input! Outside of range!");
            user_interface.displayPlay(pets);
            choice = getIntInput();
        }

        Pet pet = pets.get(choice - 1);
        pet.play();
    }

    private void wakePet(User user) {
        ArrayList<Pet> pets = user.getPets();
        int num_pets = user_interface.displayWake(pets);

        int choice = getIntInput();

        while ((choice < 1) || (choice > num_pets)) {
            user_interface.displayMessage("Invalid input! Outside of range!");
            user_interface.displayPlay(pets);
            choice = getIntInput();
        }

        Pet pet = pets.get(choice - 1);
        pet.play();
    }

    private void buyPet(User user, Shop shop) {
        ArrayList<Pet> pets = shop.getPets();
        int num_pets = user_interface.displayShop(pets);

        int choice = getIntInput();

        while ((choice < 1) || (choice > num_pets)) {
            user_interface.displayMessage("Invalid input! Outside of range!");
            user_interface.displayShop(pets);
            choice = getIntInput();
        }

        if (choice < num_pets+1) {
            Pet pet = pets.get(choice - 1);
            user_interface.displayMessage("What would you like to rename it to?");
            String name = getStrInput();
            pet.changeName(name);
            user.addPet(pet);
            shop.buyPet(pet);
        }
    }

    private void update(User user, Shop shop, long delta_t, long elapsed_time) {
        int seconds_passed = (int) ((elapsed_time * 9) / 25);
        int minutes_passed = (int) ((elapsed_time * 3) / 500);
        int hours_passed = (int) (elapsed_time / 10000); // 10 seconds per hour

        user_interface.displayMessage(user.getUsername());
        user_interface.displayTime(hours_passed % 24, minutes_passed % 60, seconds_passed % 60);

        if (hours_passed % (24 * 365) == 0) {
            user.newYear();
            shop.newYear();
        }

        if (hours_passed % 24 == 0) {
            newDay();

        }
        user.update(hours_passed, (int) delta_t);
        shop.update(hours_passed, (int) delta_t);
    }
}
