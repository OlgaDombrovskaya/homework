package de.ait.exceptions;

// Иерархия исключений, базовый класс FlightException для всех авиа-исключений,
// а SeatUnavailableException, NoSuchFlightException как наследники

public class SeatUnavailableException extends FlightException {

    public SeatUnavailableException(String message) {
        super(message);
    }
}
