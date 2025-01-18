package de.ait.consultation;

import java.util.ArrayList;
import java.util.List;

public class BeautySalon {

    private List<Service> services;

    public BeautySalon() {
        services = new ArrayList<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void printAllReceipts() {
        for (Service service : services)
        {
            if (service instanceof Discountable) {// Проверяем, применима ли скидка
                service.printReceipt();
                System.out.println("Скидка применена: " + ((Facial) service).getDiscountResultPrice());
            } else {
                service.printReceipt();
            }
        }
    }
}
