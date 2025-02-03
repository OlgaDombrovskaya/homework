package de.ait.homework33;

import de.ait.exceptions.SeatUnavailableException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AirlineReservationSystem {

    // Используем Map для отслеживания состояния мест на рейсах
    private Map<String, Map<Integer, Boolean>> flights = new HashMap<>();; {

    // Инициализация рейса SU100 и мест
        Map<Integer, Boolean> SU100Seats = new HashMap<>();
        SU100Seats.put(1, false);  // Место 1 свободно
        SU100Seats.put(2, false);  // Место 2 свободно
        SU100Seats.put(3, false);  // Место 3 свободно
        flights.put("SU100", SU100Seats); // Добавляем рейс SU100

        // Инициализация рейса BA202 и мест
        Map<Integer, Boolean> BA202Seats = new HashMap<>();
        BA202Seats.put(10, false);  // Место 10 свободно
        BA202Seats.put(11, false);  // Место 11 свободно
        BA202Seats.put(12, false);  // Место 12 свободно
        flights.put("BA202", BA202Seats); // Добавляем рейс BA202
    }

    // Метод для резервирования места на рейсе
    public void reserveSeat(String flightNumber, int seatNumber, String passengerName) throws SeatUnavailableException {
        log.info("Попытка забронировать место: рейс " + flightNumber + ", место " + seatNumber);

        if (flightNumber == null || flightNumber.isEmpty()) {
            throw new IllegalArgumentException("Некорректный номер рейса: " + flightNumber);
        }

        if (seatNumber <= 0) {  // Проверяем номер запрашиваемого места
            throw new IllegalArgumentException("Некорректный номер места: " + seatNumber);
        }

        if (passengerName == null || passengerName.trim().isEmpty()) {  // Проверяем имя пассажира
            throw new IllegalArgumentException("Некорректное имя пассажира для места: " + seatNumber);
        }

        // Проверка, существует ли рейс
        Map<Integer, Boolean> seats = flights.get(flightNumber);
        if (seats == null) {
            throw new IllegalArgumentException("Рейс с номером " + flightNumber + " не существует.");
        }

        // Проверка, существует ли место
        if (!seats.containsKey(seatNumber)) {
            throw new IllegalArgumentException("Такого места на рейсе " + flightNumber + " нет.");
        }

        // Проверка, свободно ли место
        if (!seats.get(seatNumber)) {  // Если место занято
            throw new SeatUnavailableException("Место номер " + seatNumber + " на рейсе " + flightNumber + " уже занято.");
        } else {
            seats.put(seatNumber, true); // Помечаем место как занятое
            log.info("Место " + seatNumber + " успешно забронировано для " + passengerName + " на рейсе " + flightNumber);
            System.out.println("Место " + seatNumber + " успешно забронировано для " + passengerName + " на рейсе " + flightNumber);
        }
    }

    // Метод для отмены бронирования
    public void cancelReservation(String flightNumber, int seatNumber) throws SeatUnavailableException {
        log.info("Попытка отмены бронирования для места: рейс " + flightNumber + ", место " + seatNumber);

        // Проверка на существование рейса
        Map<Integer, Boolean> seats = flights.get(flightNumber);
        if (seats == null) {
            throw new IllegalArgumentException("Рейс с номером " + flightNumber + " не существует.");
        }

        // Проверка на существование места
        if (!seats.containsKey(seatNumber)) {
            throw new IllegalArgumentException("Такого места на рейсе " + flightNumber + " нет.");
        }

        // Если место уже свободно, выбрасываем исключение
        if (seats.get(seatNumber) == false) {
            throw new SeatUnavailableException("Невозможно отменить бронирование для места " + seatNumber + " на рейсе " + flightNumber + ", так как оно не забронировано.");
        }

        seats.put(seatNumber, false); // Помечаем место как свободное
        log.info("Бронирование для места " + seatNumber + " на рейсе " + flightNumber + " успешно отменено.");
        System.out.println("Бронирование для места " + seatNumber + " на рейсе " + flightNumber + " успешно отменено.");
    }
}