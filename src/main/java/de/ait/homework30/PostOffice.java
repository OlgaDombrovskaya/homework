package de.ait.homework30;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PostOffice {

    private List<MailItem> mailItems;


    public PostOffice() {
        mailItems = new ArrayList<>();
    }

    public void addMailItem(MailItem item) {//добавляет отправление в список
        if (item == null) {
            log.warn("Параметр Null");
            System.out.println(" Параметр Null"); // Logging and printing a warning if the item is null.
        } else {
            mailItems.add(item);
            log.info("MailItem was added"); // Logging the addition of an item.
        }
    }

    public void calculateTotalShippingCost() {//выводит общую стоимость доставки для всех отправлений в списке
        System.out.println("------------------------------");
        if (mailItems.isEmpty()) {
            System.out.println("Список пуст");
            log.warn("Список пуст");
        } else {
            double totalCost = 0;
            for (MailItem item : mailItems) {
                totalCost = totalCost + item.calculateShippingCost();
            }
            System.out.println("Общая стоимость доставки: " + totalCost + " евро");
        }
    }

    public void printAllDetails() {//выводит информацию обо всех отправлениях
        System.out.println("------------------------------");
        if (mailItems.isEmpty()) {
            System.out.println("Список пуст");
            log.warn("Список пуст");
        } else {
            for (MailItem item : mailItems) {
                item.printDetails();
                System.out.println("Стоимость доставки: " + item.calculateShippingCost() + " евро\n");
            }
        }
    }

    // Добавьте этот метод для получения списка отправлений
    public List<MailItem> getMailItems() {
        return mailItems;
    }
}
