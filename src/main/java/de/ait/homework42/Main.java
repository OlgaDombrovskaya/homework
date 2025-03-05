package de.ait.homework42;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library<PaperBook> paperBooks = new Library<>();
        paperBooks.addBook(new PaperBook("Война и мир", "Лев Толстой", 500));
        paperBooks.addBook(new PaperBook("Преступление и наказание", "Федор Достоевский",300));
        System.out.println("Бумажные книги:");
        paperBooks.listBooks();

        Library<EBook> eBookLibrary = new Library<>();
        eBookLibrary.addBook(new EBook("1984", "Джордж Оруэлл", 30));
        eBookLibrary.addBook(new EBook("Brave New World", "Aldous Huxley",5));
        eBookLibrary.addBook(new EBook("Fahrenheit 451", "Ray Bradbury", 10));

        System.out.println("\nЭлектронные книги до удаления:");
        eBookLibrary.listBooks();

        // Удаление книги
        String bookToRemove = "1984";
        if (eBookLibrary.removeBook(bookToRemove)) {
            System.out.println("\nКнига '" + bookToRemove + "' удалена.");
        } else {
            System.out.println("\nКнига '" + bookToRemove + "' не найдена.");
        }

        System.out.println("\nЭлектронные книги после удаления:");
        eBookLibrary.listBooks();
    }
}
