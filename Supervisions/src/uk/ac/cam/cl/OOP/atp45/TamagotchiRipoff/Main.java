package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

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
