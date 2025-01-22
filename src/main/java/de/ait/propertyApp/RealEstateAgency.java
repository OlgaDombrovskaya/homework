package de.ait.propertyApp;

import java.util.ArrayList;
import java.util.List;

public class RealEstateAgency {

    private List<Property> properties;

    public RealEstateAgency() {
        properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Property property : properties) {
            totalPrice += property.calculatePrice();
        }
        System.out.println("Общая стоимость всех объектов недвижимости: " + totalPrice + " евро");
        return totalPrice;  // Возвращаем итоговую стоимость
    }

    public void printAllDetails() {
        for (Property property : properties) {
            property.printDetails();
            System.out.println("------------------------------");
        }
    }
    // Новый метод, возвращающий список недвижимости
    public List<Property> getProperties() {
        return properties;
    }
}