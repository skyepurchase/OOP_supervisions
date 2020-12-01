package uk.ac.cam.cl.OOP.atp45.supervision3;

public class Car {
    public final String manufacturer;
    public final int age;

    public Car(String manufacturer, int age) {
        this.manufacturer = manufacturer;
        this.age = age;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getAge() {
        return age;
    }
}
