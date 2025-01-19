package de.ait.homework30;

import java.util.ArrayList;
import java.util.List;

public class PostOffice {

    private List<MailItem> mailItems;

    public PostOffice() {
        mailItems = new ArrayList<>();
    }

    public void addMailItem(MailItem item) {//добавляет отправление в список
        mailItems.add(item);
    }

    public void calculateTotalShippingCost() {//выводит общую стоимость доставки для всех отправлений в списке
        double totalCost = 0;

        for (MailItem item : mailItems) {
            totalCost = totalCost + item.calculateShippingCost(); }
            System.out.println("Общая стоимость доставки: " + totalCost + " евро");
        }

    public void printAllDetails() {//выводит информацию обо всех отправлениях
        for (MailItem item : mailItems) {
            item.printDetails();
            System.out.println("Стоимость доставки: " + item.calculateShippingCost() + " евро\n");
        }
    }
    // Getter для списка mailItems
    public List<MailItem> getMailItems() {
        return mailItems;
    }
}
