package de.ait.genericsLesson2;

public class ArtStyle {
    private String styleName; //например, "Impressionism", "Cubism"

    public ArtStyle(String styleName) {
        this.styleName = styleName;
    }

    public String getStyleName() {
        return styleName;
    }

    @Override
    public String toString() {
        return "ArtStyle{" +
                "styleName='" + styleName + '\'' +
                '}';
    }
}
