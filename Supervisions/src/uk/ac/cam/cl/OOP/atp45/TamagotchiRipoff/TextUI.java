package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;
import java.util.Scanner;

class TextUI implements UI{
    private static final TextUI instance = new TextUI();
    private static final Scanner scanner = new Scanner(System.in);

    private TextUI() {

    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void displayPets(ArrayList<Pet> pets) {
        System.out.println("Here are your lovely pets!");
        int i = 1;
        for (Pet pet : pets) {
            System.out.print(i);
            System.out.println(pet);
            i++;
        }
        System.out.println();
    }

    public int displayPets(ArrayList<Pet> pets, boolean awake) {
        int i = 1;
        for (Pet pet : pets) {
            if (pet.isAwake() && awake) {
                System.out.print(i);
                System.out.println(pet);
                i++;
            } else if (!pet.isAwake() && !awake){
                System.out.print(i);
                System.out.println(pet);
                i++;
            }
        }
        System.out.println();
        return i;
    }

    @Override
    public void displayMenu(ArrayList<String> choices) {
        System.out.println("What would you like to do?");
        for (String choice : choices) {
            System.out.println(choice);
        }
        System.out.println();
    }

    @Override
    public int displayShop(ArrayList<Pet> pets) {
        int num_pets = displayPets(pets, true);
        System.out.printf("%d. Don't buy a pet", num_pets + 1);
        System.out.println();
        System.out.println();
        return num_pets;
    }

    @Override
    public int displayFeed(ArrayList<Pet> pets) {
        System.out.println("Which pet would you like to feed?");
        int num_pets = displayPets(pets, true);
        System.out.println();
        return num_pets;
    }

    @Override
    public int displayPlay(ArrayList<Pet> pets) {
        System.out.println("Which pet would you like to play with?");
        int num_pets = displayPets(pets, true);
        System.out.println();
        return num_pets;
    }

    @Override
    public int displayWake(ArrayList<Pet> pets) {
        System.out.println("Which pet would you like to wake up?");
        int num_pets = displayPets(pets, false);
        System.out.println();
        return num_pets;
    }

    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
        System.out.println();
    }

    @Override
    public void displayTime(int hr, int min, int sec) {
        System.out.println("The time is " + hr + ":" + min + ":" + sec);
    }

    public static TextUI getInstance() {
        return instance;
    }
}
