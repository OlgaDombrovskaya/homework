package de.ait.homework30;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Advertisement extends MailItem {

    private int quantity; // количество копий

    private static final Logger logger = LoggerFactory.getLogger(Advertisement.class);

    public Advertisement(String sender, String recipient, double weight, int quantity) {
        super(sender, recipient, weight);
        if (quantity < 0){
            logger.error("Количество листовок не может быть отрицательным!");
            System.out.println("Количество листовок не может быть отрицательным!");
        }
        this.quantity = quantity;
    }

    @Override
    public double calculateShippingCost() {
        // Если количество листовок равно 0, то стоимость доставки 0
        if (quantity == 0) {
            System.out.println("Количество рекламных листовок равно 0!");
            logger.warn("Количество рекламных листовок равно 0!");
            return 0;  // Нечего отправлять
        }

        // Рассчитываем количество пакетов
        int numberOfPackets;

        // Если количество листовок делится на 50 нацело, то пакетов будет количество листовок / 50
        if (quantity % 50 == 0) {
            numberOfPackets = quantity / 50;
            logger.info("Количество листовок делится на 50 нацело. Количество пакетов: {}", numberOfPackets);
        } else {
            // Если остаток от деления не ноль, добавляем еще один пакет
            numberOfPackets = (quantity / 50) + 1;
            logger.info("Количество листовок не делится на 50 нацело. Количество пакетов: {}", numberOfPackets);
        }

        // Стоимость доставки за количество пакетов
        return numberOfPackets * 1; // 1 евро за каждый пакет
    }
    @Override
    public void printDetails() {
        System.out.println("Рекламная листовка:");
        super.printDetails();
        System.out.println("Количество копий: " + quantity);
    }
}