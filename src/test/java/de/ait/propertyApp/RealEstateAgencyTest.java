package de.ait.propertyApp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class RealEstateAgencyTest {

    @Test
    public void testAddProperty() {
        // Arrange: Подготовка
        RealEstateAgency agency = new RealEstateAgency();
        Apartment apartment = new Apartment("Москва, ул. Ленина, д. 10", 5, 50, true);

        // Act: Действие
        agency.addProperty(apartment);

        // Assert: Проверка
        List<Property> properties = agency.getProperties();
        assertEquals(1, properties.size());  // Проверяем, что агентство содержит 1 объект недвижимости
        assertTrue(properties.contains(apartment));  // Проверяем, что добавлена именно эта квартира
    }

    @Test
    public void testCalculateTotalPrice() {
        // Arrange: Подготовка
        RealEstateAgency agency = new RealEstateAgency();
        Apartment apartment = new Apartment("Москва, ул. Ленина, д. 10", 5, 50, true);
        House house = new House("Екатеринбург, ул. Луначарского, д. 25", 120, 500, false);
        agency.addProperty(apartment);
        agency.addProperty(house);

        double expectedTotalPrice = apartment.calculatePrice() + house.calculatePrice();

        // Act: Действие
         double actualTotalPrice = agency.calculateTotalPrice();

        // Assert: Проверка
        assertEquals(expectedTotalPrice, actualTotalPrice);  // Проверяем, что общая цена посчитана правильно
    }
}
