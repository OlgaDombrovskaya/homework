package de.ait.propertyApp;

public class CommercialProperty implements Property {
    private String address;
    private double area;
    private String businessType;

    // Конструктор с типами для склада и офиса
    public CommercialProperty(String address, double area, String businessType) {
        this.address = address;
        this.area = area;
        this.businessType = businessType.toLowerCase(); // Преобразуем тип в н
    }

    @Override
    public double calculatePrice() {
        double pricePerSquareMeter;
        switch (businessType.toLowerCase()) {
            case "офис":
                pricePerSquareMeter = 1500.0;  // Цена для офисов
                break;
            case "склад":
                pricePerSquareMeter = 800.0;   // Цена для складов
                break;
            default:
                pricePerSquareMeter = 1000.0;  // Цена для остальных типов недвижимости
        }
        return area * pricePerSquareMeter;
    }


    @Override
    public void printDetails() {
        System.out.println("Коммерческая недвижимость:");
        System.out.println("Адрес: " + address);
        System.out.println("Площадь: " + area + " м²");
        System.out.println("Тип бизнеса: " + businessType);
        System.out.println("Цена: " + calculatePrice() + " евро");
    }
}