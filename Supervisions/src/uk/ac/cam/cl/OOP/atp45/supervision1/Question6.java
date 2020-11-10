package uk.ac.cam.cl.OOP.atp45.supervision1;

public class Question6 {
    public static int vectorAddUnit(int x, int dx) {
        x = x + dx;
        return x;
    }

    public static void main(String[] args) {
        int a=0;
        int b=2;
        a = vectorAddUnit(a, 1);
        b = vectorAddUnit(b, 1);
        System.out.println(a+" "+b);
    }
}
