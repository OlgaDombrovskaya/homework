package de.ait.exceptions;
//для данного рейса нет пассажира
public class NoPassengerException extends Exception {

    public NoPassengerException(String message) {
        super(message);
    }
}
