package de.ait.consultation33;

//произведение искусства отсутствует в каталоге (проверяемое)

public class ArtworkNotFoundException extends Exception {

  public ArtworkNotFoundException(String message) {
    super(message);
  }
}
