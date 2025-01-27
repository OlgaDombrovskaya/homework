package de.ait.homework31;

import java.util.ArrayList;
import java.util.List;

public class GiftManager {

    private List<Gift> giftList;

    public GiftManager() {
        this.giftList = new ArrayList<>();
    }

    // Метод для добавления подарка
    public void addGift(Gift gift) {
        giftList.add(gift);
    }

    // Метод для фильтрации подарков по категории
    public List<Gift> filterByCategory(GiftCategory category) {
        List<Gift> filteredGifts = new ArrayList<>();
        for (Gift gift : giftList) {
            if (gift.getCategory() == category) {
                filteredGifts.add(gift);
            }
        }
        return filteredGifts;
    }

    // Метод для обновления статуса подарка по имени
    public void updateGiftStatus(String giftName, GiftStatus newStatus) {
        for (Gift gift : giftList) {
            if (gift.getName().equalsIgnoreCase(giftName)) {
                gift.setStatus(newStatus);
                return;
            }
        }
        System.out.println("Подарок с таким именем " + giftName + " не найден.");
    }

    // Метод для получения всех подарков с проверкой на пустоту
    public List<Gift> getAllGifts() {
        if (giftList.isEmpty()) {
            System.out.println("Список подарков пуст.");
            return new ArrayList<>();  // Возвращаем пустой список, если giftList пуст
        }
        return new ArrayList<>(giftList); // Возвращаем копию списка
    }
    // Метод для получения подарка по имени
    public Gift getGiftByName(String giftName) {
        for (Gift gift : giftList) {
            if (gift.getName().equalsIgnoreCase(giftName)) {
                return gift;
            }
        }
        return null;
    }

}