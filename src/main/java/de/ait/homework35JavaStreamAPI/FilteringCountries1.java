package de.ait.homework35JavaStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*1. Фильтрация стран по первой букве
У вас есть список стран:
List<String> countries = Arrays.asList("Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");

Используя Stream API, отфильтруйте страны, названия которых начинаются на букву "C".

*/
public class FilteringCountries1 {

    private static List<String> countries = Arrays.asList("Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");

    public static void main(String[] args) {

        List<String> result = countries.stream()
                .filter(countriesName -> countriesName.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println("Страны, названия которых начинаются на букву C " + result);
    }
}