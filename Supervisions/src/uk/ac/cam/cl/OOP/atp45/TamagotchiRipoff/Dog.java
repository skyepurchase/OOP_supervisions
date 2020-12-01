package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

class Dog extends Pet{
    private int timesPlayed;

    Dog(String name, char sex, int hunger_depletion, int energy_depletion, int satisfaction_depletion) {
        super(name, sex, 12, hunger_depletion, energy_depletion, satisfaction_depletion);
    }

    @Override
    public void feed() {
        hunger += 50;
    }

    @Override
    public void play() {
        satisfaction += 50;
    }

    @Override
    public void update(int hours_passed) {
        if (!awake) {
            energy += (hours_passed - time_at_sleeping) * 10;
        } else {
            energy -= energy_depletion;
        }

        hunger -= hunger_depletion;
        satisfaction -= satisfaction_depletion;

        if ((hunger < 0) || (hunger > 100) || (satisfaction == 0) || (energy == 0)) {
            die();
        }

        if (age >= death_age) {
            die();
        }
    }
}
