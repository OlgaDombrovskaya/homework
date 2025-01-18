package de.ait.consultation;

public abstract class Service {
    protected String customerName;
    protected String serviceName;
    protected double basePrice;

    public Service(String customerName, String serviceName, double basePrice) {
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.basePrice = basePrice;
    }

    public abstract double calculateTotalCost();

    public void printReceipt(){
        System.out.println("Квитанция:");
        System.out.println("Клиент: " + customerName);
        System.out.println("Услуга: " + serviceName);
        System.out.println("Общая стоимость: " + calculateTotalCost());
        System.out.println();

    }
}
