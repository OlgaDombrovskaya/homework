package de.ait.genericsLesson2;

import java.util.ArrayList;
import java.util.List;

public class ModernArtGalery <T extends ArtPiece> {
        private List<T> collection = new ArrayList<>();

        public void addArtObject(T artObject) {

            if (artObject.getYear() >= 1900) {
                collection.add(artObject);
            } else {
                System.out.println("Произведение искусства слишком старое для современной галереи: " + artObject.getYear());
            }
        }

        public void displayArtObject() {
            for (T artObject : collection) {
                System.out.println(artObject); // Выводим информацию о каждом произведении

            }
        }
}
