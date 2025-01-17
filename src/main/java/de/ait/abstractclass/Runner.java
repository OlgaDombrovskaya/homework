package de.ait.abstractclass;

public class Runner extends Athlete{

    public Runner(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void train() {
        System.out.println(getName() + "run 5 km");
    }
}
