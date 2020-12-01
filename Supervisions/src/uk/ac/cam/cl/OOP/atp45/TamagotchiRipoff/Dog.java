package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

public class Dog extends Pet{
    private int timesPlayed;

    public Dog(String name, char sex, int hunger_depletion, int energy_depletion, int satisfaction_depletion) {
        super(name, sex, 12, hunger_depletion, energy_depletion, satisfaction_depletion);
    }

    @Override
    public void feed() {
        hunger -= 50;
    }

    @Override
    public void play() {
        satisfaction += 5 * (timesPlayed + 1);
        timesPlayed++;
    }

    @Override
    public void update(int delta_t) {
        if (!awake) {
            energy += (delta_t / 180000) * 10;
        } else {
            energy -= energy_depletion;
        }

        hunger += hunger_depletion;
        satisfaction -= satisfaction_depletion;

        if ((hunger < 0) || (hunger > 100) || (satisfaction == 0) || (energy == 0)) {
            die();
        }

        if (satisfaction > 100) {
            satisfaction = 100;
        }
        if (energy < 30) {
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
        timesPlayed = 0;
    }
}
