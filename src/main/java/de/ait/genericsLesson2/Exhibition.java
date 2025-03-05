package de.ait.genericsLesson2;

import java.util.ArrayList;
import java.util.List;

public class Exhibition <T extends Artworks> {
    private List<T> collection = new ArrayList<>();


    public void addArtwork(T artwork) {
        if (artwork.getStyle().equals("Impressionism") || artwork.getStyle().equals("Cubism")) {
            collection.add(artwork);
        } else {
            System.out.println("Произведение искусства не соответствует стилю выставки: ");
        }
    }

    public void displayArtworks() {
        for (T artwork : collection) {
          System.out.println(collection);
        }
    }
}
