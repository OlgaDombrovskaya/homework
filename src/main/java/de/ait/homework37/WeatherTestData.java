package de.ait.homework37;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class WeatherTestData {

    public static List<Weather> getWeatherList() {
        return Arrays.asList(
                new Weather("New York", 10.5, false),
                new Weather("Los Angeles", 18.2, false),
                new Weather("Chicago", -2.0, true),
                new Weather("Houston", 25.0, false),
                new Weather("Miami", 30.5, true),
                new Weather("Paris", 12.0, false),
                new Weather("London", 7.5, true),
                new Weather("Berlin", 3.0, true),
                new Weather("Sydney", 22.3, false),
                new Weather("Tokyo", 15.6, true)
        );
    }

    public static void main(String[] args) {

        // Получаем список погоды
        List<Weather> weatherList = WeatherTestData.getWeatherList();

        // Задание 1: Фильтрация по температуре ниже нуля
        List<Weather> resultZeroTemperatures = weatherList.stream()
                .filter(weather -> weather.getTemperature() < 0)
                .collect(Collectors.toList());

        for (Weather weather : resultZeroTemperatures) {
            System.out.println("Города с температурой ниже нуля: " + weather.getCity() + ": " + weather.getTemperature());
        }

        // Задание 2.1: Проверка, есть ли город с температурой выше 25 градусов
        boolean hasAnyCityMoreThen25Grad = weatherList.stream()
                .anyMatch(weather -> weather.getTemperature() > 25);
        System.out.println("\nЕсть ли хотя бы один город с температурой выше 25 градусов? " + hasAnyCityMoreThen25Grad);

        // Задание 2.2: Нахождение города с максимальной температурой
        Optional<Weather> getMaxTemperatureCity = weatherList.stream()
                .max(Comparator.comparingDouble(Weather::getTemperature));
        {
            System.out.println("\nГород с максимальной температурой:" + getMaxTemperatureCity.get());
            // if (getMaxTemperatureCity.isPresent()) {
            //    // Если значение присутствует, выводим город с максимальной температурой
            //    System.out.println("\nГород с максимальной температурой: " + getMaxTemperatureCity.get());
            //} else {
            //    // Если значение отсутствует (например, если список пуст), выводим сообщение об ошибке
            //    System.out.println("\nСписок городов пуст, невозможно найти город с максимальной температурой.");
            //}


            // Дополнительное задание: Подсчёт средней температуры с использованием mapToDouble и average()
            OptionalDouble averageTemperature = weatherList.stream()
                    .mapToDouble(Weather::getTemperature)  // Преобразуем в поток примитивных значений double
                    .average();                            // Получаем среднее значение (OptionalDouble)

            // Проверка на пустой Optional
            if (averageTemperature.isEmpty()) {
                System.out.println("\nСписок городов пуст.");
            } else {
                // Если значение присутствует, выводим среднюю температуру
                System.out.println("\nСредняя температура: " + averageTemperature.getAsDouble() + "°C");
            }
        }


        // Дополнительное задание: Группировка по признаку isRainy
    Map<Boolean, List<Weather>> groupedByRain = weatherList.stream()
            .collect(Collectors.groupingBy(Weather::isRainy));

        System.out.println("\nГруппировка по признаку дождя:");
        // Обрабатываем группу дождливых городов
        if (groupedByRain.containsKey(true)) {
            System.out.println("\nДождливо:");
            for (Weather weather : groupedByRain.get(true)) {
                System.out.println(weather.getCity() + " - " + weather.getTemperature() + "°C" );
            }
        }

        // Обрабатываем группу городов без дождя
        if (groupedByRain.containsKey(false)) {
            System.out.println("\nБез дождя:");
            for (Weather weather : groupedByRain.get(false)) {
                System.out.println(weather.getCity() + " - " + weather.getTemperature() + "°C");
            }
        }

        // Сортировка данных по названию города
        List<Weather> sortedWeatherList = weatherList.stream()
                .sorted(Comparator.comparing(Weather::getCity))
                .collect(Collectors.toList());

        // Выводим отсортированный список
        System.out.println("\nСписок городов, отсортированных по названию:");
        for (Weather weather : sortedWeatherList) {
            System.out.println(weather.getCity() + " - " + weather.getTemperature() + "°C");
        }
    }
}