package de.ait.homework33;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class FlightBooking {

    public static void bookFlight(String flightNumber, String passengerName, int seatNumber) {

        if (flightNumber == null || flightNumber.trim().isEmpty()) { // Проверяем номер полета
            log.error("Номер полета отсутствует: {}", flightNumber);
            throw new IllegalArgumentException("Номер полета отсутствует: " + flightNumber);
        }

        if (passengerName == null || passengerName.trim().isEmpty()) { // Проверяем имя гостя
            log.error("Имя гостя отсутствует: {}", passengerName);
            throw new IllegalArgumentException("Имя гостя отсутствует: " + passengerName);
        }
        if (seatNumber <= 0) { // Проверяем номер места
            log.error("Некорректный номер  места: {}", seatNumber);
            throw new IllegalArgumentException("Некорректный номер места: " + seatNumber);
        }
    }

    public static void main(String[] args) {

        FlightBooking booking = new FlightBooking();
        Faker faker = new Faker();

        try {
            booking.bookFlight("101", faker.name().lastName(), 1);
            booking.bookFlight("102", faker.name().lastName(), -1);
            booking.bookFlight("", faker.name().lastName(), 3);
            booking.bookFlight("103", "", 3);
        } catch (IllegalArgumentException exception) {
            log.error(Arrays.toString(exception.getStackTrace()));
            System.out.println(exception.getMessage());
        }
    }
}