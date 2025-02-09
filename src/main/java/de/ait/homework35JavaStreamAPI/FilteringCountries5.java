package de.ait.homework35JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
5. Фильтрация стран с названием из 6 букв
Дан список стран:
List<String> countries = Arrays.asList("Mexico", "Sweden", "Brazil", "Russia", "Canada", "France", "Norway");

Используя Stream API, отфильтруйте страны, название которых состоит из 6 букв.

6. Поиск стран с названием, содержащим букву "a"
Используя Stream API, отфильтруйте страны, названия которых содержат букву "a".
 */
public class FilteringCountries5 {

    private static List<String> countries = Arrays.asList("Mexico", "Sweden", "Brazil", "Russia", "Canada", "France", "Norway");

    public static void main(String[] args) {
        List<String> result = countries.stream()
                .filter(countriesName -> countriesName.length() == 6)
                .collect(Collectors.toList());
        System.out.println("Страны, название которых состоит из 6 букв " + result);

        String[] countriesArray = {"Mexico", "Sweden", "Brazil", "Russia", "Canada", "France", "Norway"};

        List<String> resultArray = Arrays.stream(countriesArray)
                .filter(countriesName -> countriesName.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Страны, названия которых содержат букву а " + resultArray);
    }
}
