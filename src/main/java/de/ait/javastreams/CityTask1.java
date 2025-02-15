package de.ait.javastreams;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Метод для получения списка всех прибрежных городов.
 *
 * @return список прибрежных городов
 */
public class CityTask1 {

    private static CityTestData data = new CityTestData();

    public static void main(String[] args) {
        List<City> result = getCitiesSortedNames();
        for (City city : result) {
            System.out.println(city.getName());
        }
    }

    public static List<City> getCitiesSortedNames() {
        List<City> coastalCities = data.getCities().stream()
                .filter(City::isCoastal)
                .collect(Collectors.toList());
        return coastalCities;
    }
}
