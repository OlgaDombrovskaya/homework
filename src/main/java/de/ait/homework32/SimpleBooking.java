package de.ait.homework32;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleBooking {

    public static void bookRoom(int roomNumber, String guestName) {

        if (roomNumber <= 0) { // Проверяем номер комнаты
            log.error("Некорректный номер комнаты: {}", roomNumber);
            throw new IllegalArgumentException("Некорректный номер комнаты: " + roomNumber);
        }

        if (guestName == null || guestName.trim().isEmpty()) { // Проверяем имя гостя
            log.error("Имя гостя или номер комнаты отсутствует: {}", roomNumber);
            throw new IllegalArgumentException("Имя гостя или номер комнаты отсутствует: " + roomNumber);
        } else {
            log.info ("Комната: {}. Гость:  {}", roomNumber,guestName);
            System.out.println("Комната: " + roomNumber + " успешно забронирована для " + guestName + ".");
        }
    }

    public static void main(String[] args) {

        testBookRoom(101, "Анна Иванова", false);   // Ожидаем успешное бронирование
        testBookRoom(-1, "Петр Семенов", true);     // Ожидаем ошибку с номером комнаты
        testBookRoom(202, "", true);               // Ожидаем ошибку с пустым именем гостя
        testBookRoom(303, null, true);             // Ожидаем ошибку с null вместо имени гостя
    }

    // Метод для тестирования
    public static void testBookRoom(int roomNumber, String guestName, boolean shouldThrowException) {
        try {
            if (shouldThrowException) {    // Ожидаем выброс исключения
                bookRoom(roomNumber, guestName);
                log.warn("Ожидалось исключение, но его не было для комнаты: " + roomNumber + ", на имя " + guestName);

            } else {

                bookRoom(roomNumber, guestName);  // Проверяем корректные данные
            }
        } catch (IllegalArgumentException e) {

            if (shouldThrowException) {  // Если ожидаем исключение, то проверяем, что оно произошло
                log.warn("Некорректные данные бронирования для номеров " + roomNumber + ", на имя " + guestName);
            } else {
                log.error("Неожиданное исключение для данных: комната" + roomNumber + ", имя гостя " + guestName);
            }
        } catch (Exception e) { // из-за trim
            log.error("Неожиданная ошибка");
        }
    }
}