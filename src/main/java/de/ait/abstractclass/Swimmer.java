package de.ait.abstractclass;

public class Swimmer extends Athlete {

    public Swimmer(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void train() {
        System.out.println( getName() + "swam 20 rides");
    }
}
