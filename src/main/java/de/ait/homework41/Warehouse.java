package de.ait.homework41;

import java.util.ArrayList;
import java.util.List;

public class Warehouse <T extends Product> {
    private List<T> stock;

        public Warehouse() {
        this.stock = new ArrayList<>();
    }

    // Пополнение склада
    public void addStock(T product) {
        stock.add(product);
    }

    // Поиск товара
    public T findProduct(String name) {
        for (T product : stock) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    // Вывод количества товара на складе
    public int getProductCount(String name) {
        int count = 0;
        for (T product : stock) {
            if (product.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }
}
