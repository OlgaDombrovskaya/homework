package de.ait.exceptions;
/**
 * Исключение NoGuestException
 * Это исключение выбрасывается, когда в системе не найден ни один гость,
 * но операция требует наличия гостя.
 *
 * NoGuestException Exception
 * This exception is thrown when no guest is found in the system,
 * but an operation requires a guest to be present.
 */
public class NoGuestException extends Exception {

    public NoGuestException(String message) {
        super(message);
    }
}