package de.ait.exceptions;

// Иерархия исключений, базовый класс FlightException для всех авиа-исключений,
// а SeatUnavailableException, NoSuchFlightException как наследники

public class FlightException extends Exception {

  public FlightException(String message) {
    super(message);
  }
}
