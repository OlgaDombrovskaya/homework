package de.ait.homework33;

import com.github.javafaker.Faker;
import de.ait.exceptions.NoPassengerException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class FlightReservation {

    private static String[] flights = {"SU100", "BA202", "LH300", "AF101", "AA777"};
    private static String[] passengers = new String[5];

    public static void addPassenger(int flightIndex, String passengerName) {

        try {
            if (flightIndex < 0 || flightIndex >= flights.length) { // Проверка индекса рейса
                log.error("Неверный индекс рейса: {}", flightIndex);
                throw new ArrayIndexOutOfBoundsException("Неверный индекс рейса: " + flightIndex);
            }
            if (passengerName == null || passengerName.trim().isEmpty()) { // Проверка имени пассажира
                log.error("Имя пассажира не может быть пустым или null");
                throw new IllegalArgumentException("Имя пассажира не может быть пустым или null");

            }
            passengers[flightIndex] = passengerName; // записывает имя пассажира в passengers[flightIndex]
            log.info("Пассажир {} успешно добавлен на рейс {}", passengerName, flights[flightIndex]);
            System.out.println("Пассажир " + passengerName + " успешно добавлен на рейс: " + flights[flightIndex]);

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            log.error("Ошибка при добавлении пассажира: {}", e.getMessage());
            System.out.println("Ошибка при добавлении пассажира: " + e.getMessage());
        }
    }

    public static String getPassenger(int flightIndex) {
        try {
            if (flightIndex < 0 || flightIndex >= flights.length) {
                log.error("Неверный индекс рейса: {}", flightIndex);
                throw new ArrayIndexOutOfBoundsException("Неверный индекс рейса: " + flightIndex);
            }
            if (passengers[flightIndex] == null) {
                log.error("Для рейса " + flights[flightIndex] + " нет пассажира.");
                throw new NoPassengerException("Для рейса " + flights[flightIndex] + " нет пассажира.");
            }
            return passengers[flightIndex];
        } catch (NoPassengerException | ArrayIndexOutOfBoundsException e) {
            log.error("Ошибка при получении данных пассажира: {}", e.getMessage());
            System.out.println("Ошибка при получении данных пассажира: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        FlightReservation flightReservation = new FlightReservation();
        Faker faker = new Faker();

        try {
            flightReservation.addPassenger(1, faker.name().lastName());
            flightReservation.addPassenger(-1, faker.name().lastName());
            flightReservation.addPassenger(3, null);
            flightReservation.addPassenger(2, "");

            flightReservation.getPassenger(1);
            flightReservation.getPassenger(-1);
            flightReservation.getPassenger(303);
            flightReservation.getPassenger(0);

        } catch (IllegalArgumentException exception) {
            log.error(Arrays.toString(exception.getStackTrace()));
            System.out.println(exception.getMessage());
        }
    }
}