package de.ait.javastreams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Метод для получения списка городов, отсортированных по возрастанию численности населения.
 *
 * @return список городов, отсортированных по населению
 *
 * Method to get a list of cities sorted by population in ascending order.
 *
 * @return a list of cities sorted by population
 */
public class CityTask3 {

    private static CityTestData data = new CityTestData();

    public static void main(String[] args) {

        // Выводим отсортированный список через цикл for
        System.out.println(getCitiesSortedPopulation());

        List<City> result = getCitiesSortedNames();
        for (City city : result) {
            System.out.println(city.getName());
        }
    }
    public static List<City> getCitiesSortedPopulation() {
        return data.getCities().stream()
                .sorted(Comparator.comparingInt(City::getPopulation))
                .collect(Collectors.toList());
    }
    /**
     * Метод для получения списка городов, отсортированных по названию.
     *
     * @return список городов, отсортированных по названию
     *
     * Method to get a list of cities sorted by name.
     *
     * @return a list of cities sorted by name
     */

    // Метод для сортировки городов по названию
    public static List<City> getCitiesSortedNames() {
        return data.getCities().stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
    }
}