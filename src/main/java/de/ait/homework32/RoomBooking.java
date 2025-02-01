package de.ait.homework32;

import de.ait.exceptions.NoGuestException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RoomBooking {

    private static int[] rooms = {101, 102, 103, 201, 202};
    private static String[] guests = new String[5];

    public static void addGuest(int roomIndex, String guestName){
        if (roomIndex < 0 || roomIndex >= rooms.length) { // Проверка корректности индекса комнаты
           log.error("Некорректный индекс комнаты: {}", roomIndex);
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс комнаты: " + roomIndex);
        }
        if (guestName == null || guestName.trim().isEmpty()) { // Проверка корректности имени гостя
            log.error("Некорректное имя гостя: {}", guestName);
            throw new IllegalArgumentException("Некорректное имя гостя" + guestName);
        }

        guests[roomIndex] = guestName;  // Добавление имени гостя в массив
        log.info("Гость {} добавлен в комнату {}", guestName,rooms[roomIndex]);
        System.out.println("Гость " + guestName + " добавлен в комнату " + rooms[roomIndex]);
    }

    public static String getGuest(int roomIndex) throws NoGuestException {
        if (roomIndex < 0 || roomIndex >= rooms.length) { // Проверка корректности индекса комнаты
            log.error("Некорректный индекс комнаты: {}", roomIndex);
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс комнаты: " + roomIndex);
        }
        // Проверка, есть ли гость в указанной комнате
        if (guests[roomIndex] == null) {
            log.error("В комнате:{} нет гостя");
            throw new NoGuestException("В комнате " + rooms[roomIndex] + " нет гостя.");
        }
        // Возвращаем имя гостя
        return guests[roomIndex];
    }

    public static void main(String[] args) {

        try {
            addGuest(0, "Кирилл Иванов");   // Тестирование корректных данных
            addGuest(1, "Светлана Петрова");

            addGuest(9, "Денис Сидоров"); // Некорректный индекс
            addGuest(4, ""); // пустое имя

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exception) {
            log.error(exception.getMessage());
            System.out.println(exception.getMessage());
        }

        try {
            // Тестирование получения гостя из комнаты
            System.out.println("Гость в комнате 1: " + getGuest(0));
            System.out.println("Гость в комнате 2: " + getGuest(1));

            // Тестирование получения гостя из пустой комнаты
            System.out.println("Гость в комнате 3: " + getGuest(4));  // Здесь гость отсутствует
        } catch (ArrayIndexOutOfBoundsException | NoGuestException exception) {
            log.error(exception.getMessage());
            System.out.println(exception.getMessage());
        }
    }
}