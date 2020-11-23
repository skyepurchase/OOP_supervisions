package uk.ac.cam.cl.OOP.atp45.supervision2;

public class Question7 {
    public static void main(String[] args) {
        testOutput(); // Person details: Joe Bloggs like all people lives on Earth
        Person.setHome_planet("Mars"); // Not changing p, and outside the method
        testOutput(); // Person details: Joe Bloggs like all people lives on Mars
    }

    public static void testOutput() {
        Person p = new Person("Joe", "Bloggs");
        System.out.println("Person details: " + p);
    }
}

class Person {
    private final String first_name;
    private final String second_name;
    private static String home_planet = "Earth";


    public Person(String first_name, String second_name) {
        this.first_name = first_name;
        this.second_name = second_name;
    }

    public static void setHome_planet(String home_planet) {
        Person.home_planet = home_planet;
    }

    @Override
    public String toString() {
        return first_name + " " + second_name  + " like all people lives on " + home_planet;
    }
}
