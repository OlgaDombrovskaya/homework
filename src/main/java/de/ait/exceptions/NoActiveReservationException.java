package de.ait.exceptions;
/**
 * Исключение NoActiveReservationException
 * Это исключение выбрасывается, когда пользователь пытается отменить или изменить бронирование,
 * но у него нет активного бронирования в системе.
 *
 * NoActiveReservationException Exception
 * This exception is thrown when a user attempts to cancel or modify a reservation,
 * but no active reservation exists in the system.
 */
public class NoActiveReservationException extends Exception {

    public NoActiveReservationException(String message) {
        super(message);
    }
}
