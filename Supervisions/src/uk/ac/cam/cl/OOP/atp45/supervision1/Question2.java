package uk.ac.cam.cl.OOP.atp45.supervision1;

public class Question2 {

    public static void main(String[] args) {
        int primitive; // This is a primitive named primitive
        // Primitive datatypes include byte, short, int, long, float, double, boolean and char
        primitive = 1;

        GenericClass obj = new GenericClass(primitive); // obj is a GenericClass object
        // obj references a GenericClass object in memory

        GenericClass obj2 = obj;
        System.out.println(obj2.getValue());
        // 1
        obj.setValue(2);
        System.out.println(obj2.getValue());
        // 2
        // As obj2 references the object which obj points a change through either is present in the other
    }
}


