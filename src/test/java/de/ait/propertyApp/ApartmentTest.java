package de.ait.propertyApp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class ApartmentTest {

    @Test
    public void testCalculatePriceWithElevator() {
        // Arrange: Подготовка
        Apartment apartment = new Apartment("Москва, ул. Ленина, д. 10", 5, 50, true);
        double expectedPrice = 50 * 1000 * 1.05;  // Цена с лифтом (5% надбавка)

        // Act: Действие
        double actualPrice = apartment.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCalculatePriceWithoutElevator() {
        // Arrange: Подготовка
        Apartment apartment = new Apartment("Москва, ул. Ленина, д. 10", 5, 50, false);
        double expectedPrice = 50 * 1000;  // Цена без лифта

        // Act: Действие
        double actualPrice = apartment.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }
}
