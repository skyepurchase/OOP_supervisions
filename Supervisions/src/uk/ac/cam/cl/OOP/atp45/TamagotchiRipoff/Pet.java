package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

abstract public class Pet {

    protected final char sex;
    protected final int death_age;
    protected String name;
    protected int hunger = 50;
    protected int energy = 75;
    protected int satisfaction = 25;
    protected int hunger_depletion;
    protected int energy_depletion;
    protected int satisfaction_depletion;
    protected boolean alive = true;
    protected boolean awake = true;
    protected int time_at_sleeping;
    protected int age;
    protected String sound;

    Pet(String name, char sex, int death_age, int hunger_depletion, int energy_depletion, int satisfaction_depletion) {
        this.name = name;
        this.sex = sex;
        this.death_age = death_age;
        this.hunger_depletion = hunger_depletion;
        this.energy_depletion = energy_depletion;
        this.satisfaction_depletion = satisfaction_depletion;
    }

    abstract public void feed();
    abstract public void play();
    abstract public void update(int delta_t);
    abstract public void newDay();

    public void sleep() {
        awake = false;
    }

    public boolean isDead() {
        return !alive;
    }

    public boolean isAwake() {
        return awake;
    }

    protected void die() {
        alive = false;
        hunger = 0;
        energy = 0;
        satisfaction = 100;
    }

    public void newYear() {
        age++;
    }

    public void changeName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nName: " + name +
                "\nSex: " + sex +
                "\nAge: " + age +
                "\nEnergy: " + energy +
                "\nSatisfaction: " + satisfaction +
                "\nHunger: " + hunger;
    }
}
