package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;

interface UI {
    String getInput();
    void displayNoPets();
    void displayPets(ArrayList<Pet> pets);
    void displayMenu(ArrayList<String> choices);
    int displayShop(ArrayList<Pet> pets);
    int displayFeed(ArrayList<Pet> pets);
    int displayPlay(ArrayList<Pet> pets);
    int displayWake(ArrayList<Pet> pets);
    void displayMessage(String msg);
    void displayTime(int hr, int min, int sec);
}
