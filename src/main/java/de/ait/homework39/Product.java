package de.ait.homework39;

import java.io.Serializable;
/*serialVersionUID — это уникальный идентификатор, который помогает JVM
при десериализации объектов убедиться, что версия сериализованного объекта совпадает с текущей версией класса.

Если нужно изменить структуру класса, например, добавить новые поля или изменить существующие,
десериализация объектов, сериализованных с предыдущими версиями класса, может привести к ошибкам.
В этом случае, если версия класса изменяется, но serialVersionUID остается прежним,
 JVM попытается использовать старую версию класса для десериализации данных.
  Это может привести к потере данных, несоответствию типов данных или даже сбоям в программе.
 */
public class Product implements Serializable {

   // private static final long serialVersionUID = 1L; //статическое поле для контроля версий
    private static final long serialVersionUID = 2L;

    private String name;
    private double price;
    private int quantity; // количество на складе

    private transient String promoCode; //промо-код
    private String category;  // Новое поле для категории
    private String description;  // Новое поле для описания

    public Product(String name, double price, int quantity, String promoCode, String category, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promoCode = promoCode;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", promoCode='" + promoCode + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
