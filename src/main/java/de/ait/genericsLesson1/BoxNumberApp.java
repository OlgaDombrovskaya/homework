package de.ait.genericsLesson1;
// Основной класс приложения для демонстрации работы с классом BoxNumber

public class BoxNumberApp {

    public static void main(String[] args) {
        // Создание коробки для хранения целого числа
        // Creating a box to store an integer
        BoxNumber<Integer> boxNumber = new BoxNumber<>(20);
        System.out.println(boxNumber.getNumber());

        // Создание коробки для хранения числа с плавающей точкой
        // Creating a box to store a floating-point number
        BoxNumber<Double> boxNumberDouble = new BoxNumber<>(20.5);
        System.out.println(boxNumberDouble.getDoubleNumber());
    }
}
