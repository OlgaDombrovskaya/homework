package de.ait.homework41;

public class Electronics extends Product {

    private String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public String getDescription() {
        return "Электроника '" + getName() + "' от бренда " + brand + ", цена: " + getPrice() + " руб.";
    }
}
