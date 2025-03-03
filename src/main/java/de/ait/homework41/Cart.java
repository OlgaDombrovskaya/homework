package de.ait.homework41;

import java.util.ArrayList;
import java.util.List;

public class Cart<T extends Product> {
    private List<T> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<T> getItems() {
        return items;
    }

    // Метод для добавления товара в корзину
    public void addProduct(T product) {
        items.add(product);
    }

    // Метод для удаления товара по названию
    public boolean removeProductByName(String name) {
        return items.removeIf(product -> product.getName().equals(name));
    }

    // Метод для подсчета итоговой стоимости товаров в корзине
    public double getTotalPrice() {
        double total = 0;
        for (T product : items) {
            total += product.getPrice();
        }
        return total;
    }

    // Метод для вывода информации о каждом товаре
    public void printCartDetails() {
        for (T product : items) {
            System.out.println(product.getDescription());
        }
    }

    public List<T> filterByPrice(double minPrice, double maxPrice) {
        List<T> filteredItems = new ArrayList<>();
        for (T product : items) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredItems.add(product);
            }
        }
        return filteredItems;
    }
}
