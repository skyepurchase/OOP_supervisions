package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

class Cat extends Pet {
    private int hours_slept;

    Cat(String name, char sex, int hunger_depletion, int energy_depletion, int satisfaction_depletion) {
        super(name, sex, 14, hunger_depletion, energy_depletion, satisfaction_depletion);
    }

    @Override
    public void feed() {
        hunger += 50;

        if (hunger < 0) {
            hunger = 0; // Cats can't be overfed
        }
    }

    @Override
    public void play() {
        satisfaction += 2 * hours_slept;
        energy -= 10;
    }

    @Override
    public void update(int hours_passed) {
        if (!awake) {
            hours_slept = hours_passed - time_at_sleeping;
            energy += (hours_passed - time_at_sleeping) * 5;
        } else {
            energy -= energy_depletion;
        }

        hunger -= hunger_depletion;
        satisfaction -= satisfaction_depletion;

        if ((hunger > 100) || (satisfaction == 0) || (energy == 0)) {
            die();
        }

        if (age >= death_age) {
            die();
        }
    }
}
