package de.ait.homework39;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L; //статическое поле для контроля версий

    private String name;
    private double price;
    private int quantity; // количество на складе

    private transient String promoCode; //промо-код

    public Product(String name, double price, int quantity, String promoCode) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promoCode = promoCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StoreTask{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }
}
