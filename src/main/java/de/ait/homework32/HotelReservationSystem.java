package de.ait.homework32;

import de.ait.exceptions.NoActiveReservationException;
import de.ait.exceptions.RoomUnavailableException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class HotelReservationSystem {

    // Используем Map для отслеживания состояния комнат
    private Map<Integer, Boolean> rooms;

    public HotelReservationSystem(Map<Integer, Boolean> rooms) {
        this.rooms = rooms;
    }

    public void reserveRoom(int requestedRoomNumber, String guestName) throws RoomUnavailableException {
        log.info("Попытка забронировать комнату: " + requestedRoomNumber);

        if (requestedRoomNumber <= 0) { // Проверяем номер  запрашиваемой комнаты
            throw new IllegalArgumentException("Некорректный номер комнаты: " + requestedRoomNumber);
        }

        if (guestName == null || guestName.trim().isEmpty()) { // Проверяем имя гостя
            throw new IllegalArgumentException("Некорректное имя гостя для комнаты: " + requestedRoomNumber);
        }

        // Проверка, существует ли комната
        if (!rooms.containsKey(requestedRoomNumber)) {
            throw new RoomUnavailableException("Комната с номером " + requestedRoomNumber + " не существует.");
        }
        // Проверка, свободна ли комната
        if (!rooms.get(requestedRoomNumber)) { // Если комната занята
            throw new RoomUnavailableException("Комната номер " + requestedRoomNumber + " уже занята.");
        } else {
            rooms.put(requestedRoomNumber, false); // Помечаем комнату как занятую
            log.info("Комната " + requestedRoomNumber + " успешно забронирована для " + guestName + ".");
            System.out.println("Комната " + requestedRoomNumber + " успешно забронирована для " + guestName + ".");
        }
    }

    // Метод для отмены бронирования
    public void cancelReservation(int roomNumber) throws  NoActiveReservationException {
        log.info("Попытка отмены бронирования для комнаты: " + roomNumber);
        // Проверка на существование комнаты
        if (!rooms.containsKey(roomNumber)) {
            throw new NoActiveReservationException("Комната с номером " + roomNumber + " не существует.");
        }
        // Если комната уже свободна, выбрасываем исключение
        if (rooms.get(roomNumber)) {
            throw new NoActiveReservationException("Нельзя отменить несуществующее бронирование для комнаты номер " + roomNumber + ".");
        }

        // Если комната занята, освобождаем её
        rooms.put(roomNumber, true); // Помечаем комнату как свободную
        log.info("Бронирование для комнаты номер " + roomNumber + " успешно отменено.");
        System.out.println("Бронирование для комнаты номер " + roomNumber + " успешно отменено.");
    }

    // Пример использования
    public static void main(String[] args) {
        Map<Integer, Boolean> initialRooms = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            initialRooms.put(i, true); // Все комнаты свободны
        }

        // Создаем объект системы бронирования
        HotelReservationSystem system = new HotelReservationSystem(initialRooms);

        // Пример бронирования и отмены бронирования с обработкой исключений
        try {
            system.reserveRoom(0, "Михаил Немов"); // Некорректный номер
        } catch (RoomUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        try {
            system.reserveRoom(1, "Анна Никитина");
            system.reserveRoom(2, "Сергей Петров");
            system.reserveRoom(1, "Артем Иванов"); // Попытка забронировать уже занятую комнату
        } catch (RoomUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        try {
            system.reserveRoom(3, ""); // Пустое имя
        } catch (RoomUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        // Проверка отмены бронирования
        try {
            system.cancelReservation(1); // Отмена бронирования
            system.cancelReservation(0);
        } catch (IllegalArgumentException | NoActiveReservationException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        try {
            system.cancelReservation(1); // Попытка отмены несуществующего бронирования
        } catch (IllegalArgumentException | NoActiveReservationException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        try {
            system.reserveRoom(0, "Герман Каримов"); // Попытка забронировать несуществующую комнату
        } catch (RoomUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}