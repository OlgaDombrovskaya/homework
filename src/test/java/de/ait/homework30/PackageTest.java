package de.ait.homework30;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageTest {

    @ParameterizedTest
    @CsvSource({
            "2.5, 30, 20, 15, 5",  // обычный случай: 2.5 кг * 2 евро = 5 евро
            "0, 30, 20, 15, 0",     // вес 0: 0 кг * 2 евро = 0 евро
            "-1, 30, 20, 15, 0",    // отрицательный вес: -1 кг * 2 евро = 0 евро
            "100, 30, 20, 15, 200"  // большой вес: 100 кг * 2 евро = 200 евро
    })
    void testPackageShippingCost(double weight, double length, double width, double height, double expectedCost) {
        // Arrange
        MailItem mailPackage = new Package("Scarlett Johansson", "Chris Hemsworth", weight, length, width, height);

        // Act
        double cost = mailPackage.calculateShippingCost();

        // Assert
        assertEquals(expectedCost, cost);  // Проверяем, что стоимость соответствует ожидаемой
    }


    @Test
    void testPrintDetails() {
        MailItem mailPackage = new Package("Scarlett Johansson", "Chris Hemsworth", 2.5, 30, 20, 15);
        mailPackage.printDetails();
    }
}