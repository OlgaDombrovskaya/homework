package de.ait.homework35JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*2. Фильтрация городов по длине названия
У вас есть список городов:
List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing");

Используя Stream API, отфильтруйте города, название которых длиннее 6 символов.

7. Фильтрация городов по последней букве
Используя Stream API, отфильтруйте города, у которых название заканчивается на "o".
 */

public class FilteringCities {

    private static List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing");

    public static void main(String[] args) {

        List<String> result = cities.stream()
                .filter(citiesName -> citiesName.length() > 6)
                .collect(Collectors.toList());
        System.out.println("Города, название которых длиннее 6 символов " + result);

        String [] citiesArray = {"Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing"};

        List<String> resultArray = Arrays.stream(citiesArray)
                .filter(citiesName -> citiesName.endsWith("o"))
                .collect(Collectors.toList());
        System.out.println("Города, у которых название заканчивается на о " + resultArray);
    }
}
