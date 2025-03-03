package de.ait.homework41;

import java.util.ArrayList;
import java.util.List;

public class Cart<T extends Product> {
    private List<T> basket;

    public Cart() {
        this.basket = new ArrayList<>();
    }

    public List<T> getBasket() {
        return basket;
    }

    // Метод для добавления товара в корзину
    public void addProduct(T product) {
        basket.add(product);
    }

    // Метод для удаления товара по названию
    public boolean removeProductByName(String name) {
        return basket.removeIf(product -> product.getName().equals(name));
    }

    // Метод для подсчета итоговой стоимости товаров в корзине
    public double getTotalPrice() {
        double total = 0;
        for (T product : basket) {
            total += product.getPrice();
        }
        return total;
    }

    // Метод для вывода информации о каждом товаре
    public void printCartDetails() {
        for (T product : basket) {
            System.out.println(product.getDescription());
        }
    }

    public List<T> filterByPrice(double minPrice, double maxPrice) {
        List<T> filteredItems = new ArrayList<>();
        for (T product : basket) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredItems.add(product);
            }
        }
        return filteredItems;
    }
}
