package de.ait.genericsLesson2;

import java.util.ArrayList;
import java.util.List;

public class ArtCollection <T extends Artist> {
    private List<T> artists = new ArrayList<>();

    public void addArtist(T artist) {
        artists.add(artist);
    }

    public T findArtistByName(String name) {
        for (T artist : artists) {
            if (artist.getName().equalsIgnoreCase(name)) {
                return artist;
            }
        }
        return null;
    }

    public void displayArtists() {
        for (T artist : artists) {
            System.out.println(artist);
        }
    }
}
