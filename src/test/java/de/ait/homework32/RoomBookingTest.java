package de.ait.homework32;

import de.ait.exceptions.NoGuestException;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomBookingTest {

    private RoomBooking roomBooking; // Экземпляр RoomBooking

    /**
     * Инициализация перед каждым тестом.
     * Initialization before each test.
     */
    @BeforeEach
    public void setUp() {

        // Для каждого теста очистим состояние
        // Восстанавливаем начальное состояние массива гостей
        roomBooking = new RoomBooking();  // можно также создать метод для сброса гостей  RoomBooking.setGuests(guests);
    }

    @Test
    void testAddGuestSuccess() {
        assertDoesNotThrow(() -> roomBooking.addGuest(0, "Кирилл Иванов"));
        assertDoesNotThrow(() -> roomBooking.addGuest(1, "Светлана Петрова"));
    }

    /**
     * Проверяет ошибку при добавлении гостя в несуществующую комнату.
     * Verifies failure when adding a guest to a non-existent room.
     */
    @Test
    void testAddGuestFailInvalidRoomIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> roomBooking.addGuest(9, "Денис Сидоров"));
    }

    @Test
    void testAddGuestNegativeInvalidRoomIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> roomBooking.addGuest(-9, "Денис Сидоров"));

    }

    /**
     * Проверяет ошибку при добавлении гостя с пустым именем.
     * Verifies failure when adding a guest with an empty name.
     */
    @Test
    void testAddGuest_EmptyGuestName() {
        // Проверяем, что выбрасывается исключение при пустом имени гостя
        assertThrows(IllegalArgumentException.class, () -> roomBooking.addGuest(4, ""));
    }

    @Test
    void testAddGuestFailGuestNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> roomBooking.addGuest(0, null));
    }

    @Test
    void testGetGuest_Success() {
        // Добавляем гостей в комнаты
        assertDoesNotThrow(() -> roomBooking.getGuest(0));
        assertDoesNotThrow(() -> roomBooking.getGuest(1));
    }

    @Test
    void testGetGuest_InvalidRoomIndex() {
        // Проверка на некорректный индекс комнаты
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> roomBooking.getGuest(9)
        );
    }

    @Test
    void testGetGuestNegativeInvalidRoomIndex() {
        // Проверка на некорректный индекс комнаты
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> roomBooking.getGuest(-9)
        );
    }

    @Test
    void testGetGuest_NoGuestInRoom() {
        // Проверка на получение гостя из пустой комнаты
        assertThrows(NoGuestException.class, () -> roomBooking.getGuest(4)
        );
    }
}