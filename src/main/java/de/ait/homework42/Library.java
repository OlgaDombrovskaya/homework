package de.ait.homework42;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library <T extends Book> {

    private List<T> books = new ArrayList<>();

    public void addBook(T book) {
        books.add(book);
    }
   //найти книгу по названию и удалить, если такая есть.
    public boolean removeBook(String title){
        Iterator<T> iterator = books.iterator();//Итератор позволяет безопасно удалять элементы во время обхода коллекции.
        while (iterator.hasNext()) { //hasNext() проверяет, есть ли еще элементы в списке.
            T book = iterator.next(); //next() возвращает текущий элемент (T book) и сдвигает итератор дальше.
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                return true; // Книга удалена
            }
        }
        return false; // Книга не найдена
    }

    //вернуть книгу по названию (или null, если не найдена).
    public T findBook(String title){
        for (T book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
//вывести getDescription() для каждой книги в библиотеке.
   public void listBooks(){
        if (books.isEmpty()){
            System.out.println("Библиотека пуста.");
        } else {
            for (T book : books) {
                System.out.println(book.getDescription());
            }
        }
   }
}
