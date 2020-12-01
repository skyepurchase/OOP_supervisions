package uk.ac.cam.cl.OOP.atp45.supervision3;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        int manufacturerComparison = car1.manufacturer.compareTo(car2.manufacturer);
        if (manufacturerComparison != 0) {
            return manufacturerComparison;
        } else if (car1.age > car2.age) {
            return 1;
        } else if (car1.age < car2.age) {
            return -1;
        } else {
            return 0;
        }
    }
}
