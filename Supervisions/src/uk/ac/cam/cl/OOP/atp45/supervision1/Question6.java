package uk.ac.cam.cl.OOP.atp45.supervision1;

public class Question6 {
    public static void vectorAdd(int x,int y,int dx, int dy) {
        x=x+dx;
        y=y+dy;
    }
    public static void main(String[] args) {
        int a=0;
        int b=2;
        vectorAdd(a,b,1,1);
        System.out.println(a+" "+b);
        // (a,b) is still (0,2)
    }
}
