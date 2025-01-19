package de.ait.homework30;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Letter extends MailItem {

    private boolean isRegistered;

    private static final Logger logger = LoggerFactory.getLogger(Letter.class);

    public Letter(String sender, String recipient, double weight, boolean isRegistered) {
        super(sender, recipient, weight);
        this.isRegistered = isRegistered;
    }

    @Override
    public double calculateShippingCost() {
        if(getSender() == null || getRecipient() == null){
            System.out.println("Отсутствует отправитель и получатель");
          logger.warn("Отправитель и получатель не могут быть null");
        }

        double shippingCost;
        if (isRegistered) {
            shippingCost = 10;
        } else {
            shippingCost = 5;
        }
        return shippingCost;
    }


    @Override
    public void printDetails() {
        System.out.println("Письмо:");
        super.printDetails();
        if (isRegistered) {
            System.out.println("Зарегистрированное: Да");
            logger.info("Письмо зарегистрировано");
        } else {
            System.out.println("Зарегистрированное: Нет");
            logger.info("Письмо не зарегистрировано");
        }
    }
}
