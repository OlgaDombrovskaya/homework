package de.ait.homework31;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class GiftManager {

    private List<Gift> giftList;

    public GiftManager() {
        this.giftList = new ArrayList<>();
    }

    // Метод для добавления подарка
    public void addGift(Gift gift) {
        if (gift == null) {
            log.warn("Attempted to add a null gift");
        } else {
            giftList.add(gift);
            log.info("Gift was added: " + gift.getName());
        }
    }

    // Метод для фильтрации подарков по категории
    public List<Gift> filterByCategory(GiftCategory category) {

        if (category == null) {
            log.error("Category is null. Unable to filter gifts.");
            return new ArrayList<>();  // Возвращаем пустой список, если категория null
        }
        List<Gift> filteredGifts = new ArrayList<>();
        for (Gift gift : giftList) {
            if (gift.getCategory() == category) {
                filteredGifts.add(gift);
            }
        }
        return filteredGifts;
    }

    // Метод для обновления статуса подарка по имени
    public boolean updateGiftStatus(String giftName, GiftStatus newStatus) {
        if (giftName == null || newStatus == null || giftName.isEmpty()) {
            log.error("Status update is not possible. Gift: {}, Status: {}", giftName, newStatus);
            System.out.println("Подарок с таким именем " + giftName + " не найден.");
            return false;
        } else {
            for (Gift gift : giftList) {
                if (gift.getName().equalsIgnoreCase(giftName)) {
                    gift.setStatus(newStatus);
                    log.info("Status of gift {} was updated to {}", giftName, newStatus);
                    return true;
                }
            }
        }
        log.warn("Gift with name '{}' not found for status update", giftName);
        return false;
    }

    // Метод для получения всех подарков с проверкой на пустоту
    public List<Gift> getAllGifts() {
        if (giftList.isEmpty()) {
            log.info("The gift list is empty.");
            System.out.println("Список подарков пуст.");
            return new ArrayList<>();  // Возвращаем пустой список, если giftList пуст
        }
        return new ArrayList<>(giftList); // Возвращаем копию списка
    }

    // Метод для получения подарка по имени
    public Gift getGiftByName(String giftName) {
        if (giftName == null || giftName.isEmpty()) {
            log.error("Gift name is null or empty.");
            return null;
        } else {
            for (Gift gift : giftList) {
                if (gift.getName().equalsIgnoreCase(giftName)) {
                    return gift;
                }
            }
            log.warn("Gift with name '{}' not found", giftName);
            return null;
        }
    }
}