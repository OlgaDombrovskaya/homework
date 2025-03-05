package de.ait.homework42;

public class EBook extends Book {
    private double fileSizeMb;

    public EBook(String title, String author, double fileSizeMb) {
        super(title, author);
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getDescription() {
        return "Книга '" + getTitle() + "' от автора " + getAuthor()+ " с размером файла " + fileSizeMb;
    }
}
