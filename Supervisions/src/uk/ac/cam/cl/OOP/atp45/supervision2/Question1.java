package uk.ac.cam.cl.OOP.atp45.supervision2;

class Class {
    private final int x;
    private String y;

    Class(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }

    void setY(String str) {
        y = str;
    }
}

abstract class Abstract {
    private float z;
    private String type = "Abstract";

    abstract void DoSomethingwithY(float y);

    abstract float ReturnSomeZFunction();
}

interface Interface {
    void move(int x, int y);
    void attack(Object weapon);
}
