package de.ait.homework41;

public abstract class Product implements Comparable<Product> {

    private String name; // название
    private double price; // цена

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
   //абстрактный метод, который будет возвращать описание товара
    public abstract String getDescription();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
