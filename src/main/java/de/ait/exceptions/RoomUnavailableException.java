package de.ait.exceptions;
/**
 * Исключение RoomUnavailableException
 * Это исключение выбрасывается, когда запрашиваемая комната недоступна для бронирования.
 *
 * RoomUnavailableException Exception
 * This exception is thrown when the requested room is unavailable for booking.
 */
public class RoomUnavailableException extends Exception {

    public RoomUnavailableException(String message) {
        super(message);
    }
}
