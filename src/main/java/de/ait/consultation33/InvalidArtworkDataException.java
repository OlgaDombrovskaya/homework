package de.ait.consultation33;

//предоставлены некорректные данные для произведения искусства
// (пустое название или имя художника) (непроверяемое)

public class InvalidArtworkDataException extends IllegalArgumentException {

    public InvalidArtworkDataException(String message) {
        super(message);
    }
}
