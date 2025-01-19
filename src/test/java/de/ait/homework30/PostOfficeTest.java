package de.ait.homework30;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostOfficeTest {

    @Test
    void testAddMailItem() {
        PostOffice postOffice = new PostOffice();
        MailItem letter = new Letter("Leonardo DiCaprio", "Brad Pitt", 0.05, true);

        // Добавляем письмо в почтовый офис
        postOffice.addMailItem(letter);

        // Проверяем, что письмо добавлено
        assertEquals(1, postOffice.getMailItems().size());  // Список должен содержать 1 элемент
        assertEquals(letter, postOffice.getMailItems().get(0));  // Элемент должен быть тем же письмом
    }

    @Test
    void testCalculateTotalShippingCost() {
        PostOffice postOffice = new PostOffice();
        postOffice.addMailItem(new Letter("Tom Cruise", "Brad Pitt", 0.05, true));
        postOffice.addMailItem(new Package("Scarlett Johansson", "Chris Hemsworth", 2.5, 30, 20, 15));
        postOffice.addMailItem(new Advertisement("Tom Cruise", "Все жители Голливуда", 0.1, 100));

        // Ожидаем общую стоимость 10 + 5 + 2 = 17 евро
        postOffice.calculateTotalShippingCost();
    }

    @Test
    void testPrintAllDetails() {
        PostOffice postOffice = new PostOffice();
        postOffice.addMailItem(new Letter("Tom Cruise", "Brad Pitt", 0.05, true));
        postOffice.addMailItem(new Package("Scarlett Johansson", "Chris Hemsworth", 2.5, 30, 20, 15));
        postOffice.addMailItem(new Advertisement("Tom Cruise", "Все жители Голливуда", 0.1, 100));

        postOffice.printAllDetails();
    }
}