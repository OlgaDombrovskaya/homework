package de.ait.homework30;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvertisementTest {

    @ParameterizedTest
    @CsvSource({
            "-1, 0",      // -1 листовок = 0 пакетов
            "0, 0",      // 0 листовок = 0 пакетов
            "49, 1",     // 49 листовок = 1 пакет
            "50, 1",     // 50 листовок = 1 пакет
            "100, 2",    // 100 листовок = 2 пакета
            "149, 3",    // 149 листовок = 3 пакета
            "200, 4"     // 200 листовок = 4 пакета
    })
    void testCalculateShippingCost(int quantity, double expectedCost) {
        // Arrange
        Advertisement advertisement = new Advertisement("Tom Cruise", "Все жители Голливуда", 0.1, quantity);

        // Act
        double cost = advertisement.calculateShippingCost();

        // Assert
        assertEquals(expectedCost, cost);
    }

    @Test
    void testPrintDetails() {
        MailItem advertisement = new Advertisement("Tom Cruise", "Все жители Голливуда", 0.1, 100);
        advertisement.printDetails();
    }
}