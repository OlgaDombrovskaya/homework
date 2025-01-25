package de.ait.enums;

public class StreetLightApp {
    public static void main(String[] args) {
        // Пример использования перечисления Light
        for (Light light : Light.values()) {
            System.out.println("Traffic Light: " + light);
        }
    }
}
