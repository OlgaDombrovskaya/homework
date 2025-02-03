package de.ait.homework33;

import de.ait.exceptions.SeatUnavailableException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
@Slf4j
public class AirlineReservationSystemApp {

    public static void main(String[] args) {
     // Инициализация рейсов и мест
        AirlineReservationSystem system = new AirlineReservationSystem();

        // Пример бронирования и отмены бронирования с обработкой исключений
        try {
            system.reserveSeat("SU100", 1, "Михаил Немов");  // Успешное бронирование
            system.reserveSeat("SU100", 1, "Артем Иванов"); // Попытка забронировать уже занятое место
        } catch (SeatUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        try {
            system.cancelReservation("SU100", 1);  // Отмена бронирования
            system.cancelReservation("SU100", 1);  // Попытка отмены несуществующего бронирования
        } catch (IllegalArgumentException | SeatUnavailableException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        try {
            system.reserveSeat("BA202", 10, "Анна Никитина"); // Успешное бронирование
            system.reserveSeat("BA202", 10, "Сергей Петров"); // Попытка забронировать уже занятое место
        } catch (SeatUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        try {
            system.cancelReservation("BA202", 10); // Отмена бронирования
        } catch (IllegalArgumentException | SeatUnavailableException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }

        // Пример ошибки: бронирование на несуществующий рейс
        try {
            system.reserveSeat("XX123", 1, "Герман Каримов"); // Попытка забронировать несуществующий рейс
        } catch (SeatUnavailableException | IllegalArgumentException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
