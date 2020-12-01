package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

public class Cat extends Pet {
    private int hours_slept;

    public Cat(String name, char sex, int hunger_depletion, int energy_depletion, int satisfaction_depletion) {
        super(name, sex, 14, hunger_depletion, energy_depletion, satisfaction_depletion);
    }

    @Override
    public void feed() {
        hunger -= 50;

        if (hunger < 0) {
            hunger = 0; // Cats can't be overfed
        }
    }

    @Override
    public void play() {
        satisfaction += 2 * (hours_slept + 1);
        energy -= 10;
    }

    @Override
    public void update(int delta_t) {
        if (!awake) {
            hours_slept += delta_t / 180000;
            energy += ((delta_t / 180000) - time_at_sleeping) * 5;
        } else {
            energy -= energy_depletion;
        }

        hunger += hunger_depletion;
        satisfaction -= satisfaction_depletion;

        if ((hunger > 100) || (satisfaction <= 0) || (energy <= 0)) {
            die();
        }

        if (satisfaction > 100) {
            satisfaction = 100;
        }
        if (energy < 20) {
            sleep();
        } else if (energy > 100) {
            energy = 100;
        }

        if (age >= death_age) {
            die();
        }
    }

    @Override
    public void newDay() {
        hours_slept = 0;
    }
}
