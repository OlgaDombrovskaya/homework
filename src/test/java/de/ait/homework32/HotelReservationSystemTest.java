package de.ait.homework32;

import de.ait.exceptions.NoActiveReservationException;
import de.ait.exceptions.RoomUnavailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelReservationSystemTest {

    private HotelReservationSystem system;

    @BeforeEach
    public void setUp() {
        // Восстанавливаем начальное состояние системы с комнатами вручную
        initializeSystem();
    }

    private void initializeSystem() {
        // Восстанавливаем начальное состояние системы с 10 комнатами
        Map<Integer, Boolean> rooms = new HashMap<>();

        // Добавляем комнаты вручную
        rooms.put(1, true);
        rooms.put(2, true);
        rooms.put(3, true);
        rooms.put(4, true);
        rooms.put(5, true);
        rooms.put(6, true);
        rooms.put(7, true);
        rooms.put(8, true);
        rooms.put(9, true);
        rooms.put(10, true);

        system = new HotelReservationSystem(rooms);  // Передаем начальное состояние комнат
    }

    /* либо через метод for
     * @BeforeEach
     *     public void setUp() {
     *         // Инициализируем систему с комнатами, все из которых свободны
     *         Map<Integer, Boolean> rooms = new HashMap<>();
     *         for (int i = 1; i <= 10; i++) {
     *             rooms.put(i, true); // Все комнаты свободны
     *         }
     *         system = new HotelReservationSystem(rooms);  // Передаем начальное состояние комнат
     *     }
     */

    /**
     * Проверяет успешное бронирование комнаты.
     * Verifies successful room reservation.
     */
    @Test
    void testReserveRoom_Success() {
        assertDoesNotThrow(() -> system.reserveRoom(1, "Михаил Немов"));
        assertDoesNotThrow(() -> system.reserveRoom(2, "Анна Никитина"));
    }

    /**
     * Проверяет ошибку при бронировании комнаты с некорректным номером.
     * Verifies failure when booking a room with an invalid room number.
     */
    @Test
    void testReserveRoom_InvalidRoomNumber() {
        assertThrows(IllegalArgumentException.class, () -> system.reserveRoom(0, "Никита Сидоров"));
    }

    /**
     * Проверяет ошибку при бронировании комнаты с пустым именем гостя.
     * Verifies failure when booking with an empty guest name.
     */
    @Test
    void testReserveRoom_EmptyGuestName() {
        assertThrows(IllegalArgumentException.class, () -> system.reserveRoom(3, ""));
    }

    @Test
    void testReserveRoom_NullGuestName() {
        assertThrows(IllegalArgumentException.class, () -> system.reserveRoom(3, null));
    }

    /**
     * Проверяет ошибку при бронировании уже занятой комнаты.
     * Verifies failure when booking an already reserved room.
     */
    @Test
    void testReserveRoom_RoomAlreadyReserved()throws RoomUnavailableException {
        system.reserveRoom(4, "Марина Иванова");  // Бронирование первой комнаты
        assertThrows(RoomUnavailableException.class, () -> system.reserveRoom(4, "Артем Петров"));
    }

    /**
     * Проверяет ошибку при попытке забронировать несуществующую комнату.
     * Verifies failure when booking a non-existent room.
     */
    @Test
    void testReserveRoom_NonExistentRoom() {
        assertThrows(RoomUnavailableException.class, () -> system.reserveRoom(11, "Дмитрий Васильев"));
    }

    /**
     * Проверяет успешную отмену бронирования комнаты.
     * Verifies successful reservation cancellation.
     */
    @Test
    void testCancelReservation_Success()throws RoomUnavailableException {
        system.reserveRoom(5, "Анна Соколова");
        assertDoesNotThrow(() -> system.cancelReservation(5));  // Отмена бронирования
    }

    /**
     * Проверяет ошибку при отмене бронирования несуществующей комнаты.
     * Verifies failure when canceling reservation for a non-existent room.
     */
    @Test
    void testCancelReservation_NonExistentRoom() {
        assertThrows(NoActiveReservationException.class, () -> system.cancelReservation(11));
    }

    /**
     * Проверяет ошибку при отмене бронирования для комнаты без активного бронирования.
     * Verifies failure when canceling reservation for a room without an active reservation.
     */
    @Test
    void testCancelReservation_NoActiveReservation() {
        assertThrows(NoActiveReservationException.class, () -> system.cancelReservation(1));
    }

    /**
     * Проверяет ошибку при отмене бронирования для уже свободной комнаты.
     * Verifies failure when canceling reservation for an already free room.
     */
    @Test
    void testCancelReservation_AlreadyFreeRoom() {
        assertThrows(NoActiveReservationException.class, () -> system.cancelReservation(1));
    }
}