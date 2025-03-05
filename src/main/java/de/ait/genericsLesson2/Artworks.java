package de.ait.genericsLesson2;

public class Artworks {
    private String title;
    private String artist;
    private ArtStyle style;

    public Artworks(String title, String artist, ArtStyle style) {
        this.title = title;
        this.artist = artist;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public ArtStyle getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return "Artworks{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", style=" + style +
                '}';
    }
}
