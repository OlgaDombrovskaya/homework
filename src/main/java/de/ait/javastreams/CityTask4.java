package de.ait.javastreams;

import java.util.List;
/**
 * Метод для подсчета количества городов с населением более 5 миллионов.
 *
 * @return количество городов с населением более 5 миллионов
 *
 * Method to count the number of cities with a population over 5 million.
 *
 * @return the number of cities with a population over 5 million
 */
public class CityTask4 {
    public static void main(String[] args) {

        List<City> cities = CityTestData.getCities(); // Получаем список городов
        // Подсчитываем количество городов, население которых превышает 5 миллионов
        long count = countCitiesWithPopulationGreaterThanFiveMillion(cities);

        System.out.println("Количество городов с населением более 5 миллионов: " + count);
    }

    public static long countCitiesWithPopulationGreaterThanFiveMillion(List<City> cities) {
        return cities.stream()
                .filter(city -> city.getPopulation() > 5_000_000) // Фильтруем города с населением > 5 миллионов
                .count(); // Подсчитываем количество таких городов
    }
}
