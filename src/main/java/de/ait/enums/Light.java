package de.ait.enums;

public enum Light {
    RED(30),    // Красный свет горит 30 секунд // Red light lasts for 30 seconds
    YELLOW(10), // Желтый свет горит 10 секунд // Yellow light lasts for 10 seconds
    GREEN(45);  // Зеленый свет горит 45 секунд // Green light lasts for 45 seconds

    // Поле для хранения продолжительности горения цвета (в секундах)
    private int duration;

    // Конструктор для задания продолжительности горения для каждого цвета
    Light(int duration) {
        this.duration = duration;
    }

    // Метод для получения продолжительности горения цвета
    public int getDuration() {
        return duration;
    }
}
