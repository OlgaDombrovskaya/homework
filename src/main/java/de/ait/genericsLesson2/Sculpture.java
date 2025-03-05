package de.ait.genericsLesson2;

public class Sculpture implements Artwork{
    private String name;
    private String material;

    public Sculpture(String name, String material) {
        this.name = name;
        this.material = material;
    }

    @Override
    public void display() {
        System.out.println("Скульптура: " + name + ", материал: " + material);
    }
}