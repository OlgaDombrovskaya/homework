package de.ait.propertyApp;

public class PropertyManager {
    public static void main(String[] args) {

        RealEstateAgency agency = new RealEstateAgency();

        // Создание объектов недвижимости
        Apartment apartment1 = new Apartment("Москва, ул. Ленина, д. 10", 5, 50, true);
        House house1 = new House("Екатеринбург, ул. Луначарского, д. 25", 120, 500, true);
        CommercialProperty commercialProperty1 = new CommercialProperty("Санкт-Петербург, ул. Строителей, д. 12", 200, "Офис");

        // Добавление объектов в агентство
        agency.addProperty(apartment1);
        agency.addProperty(house1);
        agency.addProperty(commercialProperty1);

        // Вывод информации обо всех объектах
        agency.printAllDetails();

        // Рассчитываем общую стоимость недвижимости
        agency.calculateTotalPrice();
    }
}
