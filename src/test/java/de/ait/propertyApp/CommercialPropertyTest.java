package de.ait.propertyApp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CommercialPropertyTest {
    @Test
    public void testCalculatePriceOffice() {
        // Arrange: Подготовка
        CommercialProperty office = new CommercialProperty("Санкт-Петербург, ул. Строителей, д. 12", 200, "Офис");
        double expectedPrice = 200 * 1500;  // Цена для офиса

        // Act: Действие
        double actualPrice = office.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCalculatePriceWarehouse() {
        // Arrange: Подготовка
        CommercialProperty warehouse = new CommercialProperty("Санкт-Петербург, ул. Строителей, д. 12", 200, "Склад");
        double expectedPrice = 200 * 800;  // Цена для склада

        // Act: Действие
        double actualPrice = warehouse.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCalculatePriceDefault() {
        // Arrange: Подготовка
        CommercialProperty defaultProperty = new CommercialProperty("Санкт-Петербург, ул. Строителей, д. 12", 200, "Другое");
        double expectedPrice = 200 * 1000;  // Для прочих типов недвижимости

        // Act: Действие
        double actualPrice = defaultProperty.calculatePrice();

        // Assert: Проверка
        assertEquals(expectedPrice, actualPrice);
    }
}
