package de.ait.exceptions;

// Иерархия исключений, базовый класс FlightException для всех авиа-исключений,
// а SeatUnavailableException, NoSuchFlightException как наследники

public class NoSuchFlightException extends FlightException {

    public NoSuchFlightException(String message) {
        super(message);
    }
}
