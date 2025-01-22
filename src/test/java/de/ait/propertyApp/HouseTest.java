package de.ait.propertyApp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class HouseTest {
    @Test
    public void testCalculatePriceWithGarage() {
        // Arrange: Подготовка
        House house = new House("Екатеринбург, ул. Луначарского, д. 25", 120, 500, true);
        double expectedPrice = (120 * 800) + (500 * 200) + 5000;  // Цена с гаражом

        // Act: Действие
        double actualPrice = house.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCalculatePriceWithoutGarage() {
        // Arrange: Подготовка
        House house = new House("Екатеринбург, ул. Луначарского, д. 25", 120, 500, false);
        double expectedPrice = (120 * 800) + (500 * 200);  // Цена без гаража

        // Act: Действие
        double actualPrice = house.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }
}
