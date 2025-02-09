package de.ait.homework35JavaStreamAPI;
/*
3. Фильтрация рек с четным количеством букв в названии
Дан список рек:
List<String> rivers = Arrays.asList("Amazon", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges");

Используя Stream API, отфильтруйте только те реки, у которых чётное количество букв в названии.

8. Определение рек, содержащих более 7 букв
Используя Stream API, отфильтруйте реки, название которых содержит более 7 букв.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringRivers {

    private static List<String> rivers = Arrays.asList("Amazon", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges");

    public static void main(String[] args) {

        List<String> evenLengthRivers = rivers.stream()
                .filter(riversName -> riversName.length() % 2 == 0) // Проверяем, четное ли количество букв
                .collect(Collectors.toList());
        System.out.println("Реки с четным количеством букв: " + evenLengthRivers);

        String[] riversArray = {"Amazon", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges"};

        // Преобразуем массив в список и фильтруем по длине
        List<String> result = Arrays.stream(riversArray)  // Используем Arrays.stream() для массива
                .filter(riversName -> riversName.length() > 7) // Фильтруем по длине
                .collect(Collectors.toList());
        System.out.println("Реки с более чем 7 буквами: " + result);
    }
}