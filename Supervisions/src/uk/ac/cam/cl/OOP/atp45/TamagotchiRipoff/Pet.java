package uk.ac.cam.cl.OOP.atp45.TamagotchiRipoff;

abstract class Pet {

    protected final char sex;
    protected final int death_age;
    protected String name;
    protected int hunger = 0;
    protected int energy = 50;
    protected int satisfaction = 50;
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
    abstract public void update(int hours_passed);

    public void sleep(int hours_passed) {
        time_at_sleeping = hours_passed;
        awake = false;
    }

    boolean isDead() {
        return !alive;
    }

    boolean isAwake() {
        return awake;
    }

    protected void die() {
        alive = false;
        hunger = 0;
        energy = 0;
        satisfaction = 100;
    }

    void newYear() {
        age++;
    }

    void changeName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String msg = "\nName: " + name +
                "\nSex: " + sex +
                "\nAge: " + age +
                "\nEnergy: " + energy +
                "\nSatisfaction: " + satisfaction +
                "\nHunger: " + hunger;
        return msg;
    }
}
