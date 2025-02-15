package de.ait.javastreams;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Метод для получения списка названий всех городов в верхнем регистре.
 *
 * @return список городов с названиями в верхнем регистре
 *
 * Method to get a list of city names in uppercase.
 *
 * @return a list of cities with names in uppercase
 */
public class CityTask2 {

        private static CityTestData data = new CityTestData();

        public static void main(String[] args) {

            List<City> cityNamesUppercase = allCityNamesUppercase();
            cityNamesUppercase.forEach(city -> System.out.println(city.getName()));
        }

        public static List<City> allCityNamesUppercase() {
            return data.getCities().stream()
                    .map(city -> new City(city.getName().toUpperCase(), // Преобразование имени в верхний регистр
                            city.getCountry(), city.getPopulation(), city.isCoastal()))
                            .collect(Collectors.toList());
        }
    }