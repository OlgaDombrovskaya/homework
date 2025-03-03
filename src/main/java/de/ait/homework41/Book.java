package de.ait.homework41;

public class Book extends Product{

    private String author;


    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Книга '" + getName() + "' от автора " + author + ", цена: " + getPrice() + " руб.";
    }
}
