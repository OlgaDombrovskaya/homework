package de.ait.homework35JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
4. Фильтрация континентов по количеству символов
Дан список континентов:
List<String> continents = Arrays.asList("Europe", "Asia", "Africa", "Australia", "Antarctica", "South America", "North America");

Используя Stream API, отфильтруйте континенты, у которых название короче 7 символов.

9. Фильтрация континентов по первой букве
Используя Stream API, отфильтруйте континенты, названия которых начинаются на "A".
 */

public class FilteringContinents {

   private static List<String> continents = Arrays.asList("Europe", "Asia", "Africa", "Australia", "Antarctica", "South America", "North America");

    public static void main(String[] args) {

        List<String> result = continents.stream()
                .filter(continentsName -> continentsName.length() < 7)
                .collect(Collectors.toList());
        System.out.println("Континенты, у которых название короче 7 символов" + result);

        String []continentsArray = {"Europe", "Asia", "Africa", "Australia", "Antarctica", "South America", "North America"};

        List<String> resultArray = Arrays.stream(continentsArray)
                .filter(continentsName -> continentsName.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Континенты, названия которых начинаются на А " + resultArray);
    }
}
