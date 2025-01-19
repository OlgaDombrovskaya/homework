package de.ait.homework30;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterTest {

    // Параметризированный тест для метода calculateShippingCost()
    @ParameterizedTest
    @CsvSource({
            "'Leonardo DiCaprio', 'Brad Pitt', 0.05, true, 10", // Зарегистрированное письмо
            "'Tom Cruise', 'Все жители Голливуда', 0.05, false, 5", // Обычное письмо
            "'null', 'Brad Pitt', 0.05, false, 5", // Письмо с null значениями
            "'Scarlett Johansson', 'null', 0.05, false, 5" // Письмо с null значениями
    })
    void testCalculateShippingCost(String sender, String recipient, double weight, boolean isRegistered, double expectedCost) {
        // Arrange
        Letter letter = new Letter(sender, recipient, weight, isRegistered);

        // Act
        double actualCost = letter.calculateShippingCost();

        // Assert
        assertEquals(expectedCost, actualCost, "Стоимость доставки должна быть правильной.");
    }


    @Test
    void testPrintDetails() {
        MailItem letter = new Letter("Leonardo DiCaprio", "Brad Pitt", 0.05, true);
        letter.printDetails();
    }
}