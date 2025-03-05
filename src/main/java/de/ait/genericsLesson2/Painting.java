package de.ait.genericsLesson2;

public class Painting implements Artwork{

    private String title;
    private String artist;

    public Painting(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Картина: " + title + ", автор: " + artist);
    }


    @Override
    public String toString() {
        return "Painting{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
