package de.ait.homework42;

public class PaperBook extends Book{

    private int pages;

    public PaperBook(String title, String author, int pages) {
        super(title, author);
        this.pages = pages;
    }

    @Override
    public String getDescription() {
        return "Книга '" + getTitle() + "' от автора " + getAuthor()+ ", " + pages + " страниц";
    }
}
