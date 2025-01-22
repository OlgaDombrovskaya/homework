package de.ait.propertyApp;

public class Apartment implements Property {
    private String address;
    private int floor;
    private double area;
    private boolean hasElevator;

    public Apartment(String address, int floor, double area, boolean hasElevator) {
        this.address = address;
        this.floor = floor;
        this.area = area;
        this.hasElevator = hasElevator;
    }

    @Override
    public double calculatePrice() {
        double basePrice = 1000;  // Базовая цена за 1 м²
        if (hasElevator) {
            basePrice *= 1.05;  // Увеличение на 5% если есть лифт
        }
        return basePrice * area;
    }

    @Override
    public void printDetails() {
        System.out.println("Квартира:");
        System.out.println("Адрес: " + address);
        System.out.println("Этаж: " + floor);
        System.out.println("Площадь: " + area + " м²");
        if (hasElevator) {
            System.out.println("Наличие лифта: Да");
        } else {
            System.out.println("Наличие лифта: Нет");}//("Наличие лифта: " + (hasElevator ? "Да" : "Нет"));
        System.out.println("Цена: " + calculatePrice() + " евро");
    }
    public String getAddress() {
        return address;
    }

    public int getFloor() {
        return floor;
    }

    public double getArea() {
        return area;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }
}


