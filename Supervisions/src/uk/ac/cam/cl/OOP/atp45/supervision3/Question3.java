package uk.ac.cam.cl.OOP.atp45.supervision3;

import java.util.ArrayList;
import java.util.Collections;

public class Question3 {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Royles Royce", 50));
        cars.add(new Car("Royles Royce", 55));
        cars.add(new Car("Aston Martin", 40));
        cars.add(new Car("Lamborghini", 20));
        cars.add(new Car("Robin Reliant", 40));

        System.out.println(cars.get(0).getManufacturer()); // First added item: Royles Royce
        cars.sort(new CarComparator()); // Uses our comparator
        System.out.println(cars.get(0).getManufacturer()); // First alphabetical manufacturer: Aston Martin
        System.out.println(cars.get(3).getAge()); // Both Royles Royces have the same name so the youngest is first
    }
}
