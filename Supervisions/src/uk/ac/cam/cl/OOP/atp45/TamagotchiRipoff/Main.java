package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tomagotchi tomagotchi = new Tomagotchi("Skye");
        try {
            tomagotchi.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
