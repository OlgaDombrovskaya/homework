package de.ait.enums;

public class SeasonApp {
    public static void main(String[] args) {
        // Пример использования перечисления Season
        for (Season season : Season.values()) {
            System.out.println("Season: " + season);
        }
    }
}
