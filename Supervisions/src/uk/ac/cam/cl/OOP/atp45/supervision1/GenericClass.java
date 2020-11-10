package uk.ac.cam.cl.OOP.atp45.supervision1;

public class GenericClass { // This is a generic class
    // A class is a template describing the state and behaviour of an object

    int value; // It has attributes

    public GenericClass(int value) { // A constructor
        this.value = value; // Which can initialise attributes
    }

    public int getValue() { // And methods
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
