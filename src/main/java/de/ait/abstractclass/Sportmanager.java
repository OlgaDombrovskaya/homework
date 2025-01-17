package de.ait.abstractclass;

import java.util.ArrayList;
import java.util.List;

public class Sportmanager {
    public static void main(String[] args) {

        // Создание списка для хранения атлетов
        List<Athlete> athleteList = new ArrayList<>();

        // Добавление атлетов в список
        Athlete max = new Runner("Max", 3);
        athleteList.add(max);
        athleteList.add(new Swimmer("John", 2));
        athleteList.add(new Runner("Peter", 1));
        athleteList.add(new Swimmer("Paul", 4));

        // Итерация по списку, отображение информации и запуск тренировки
        for (Athlete athlete : athleteList) {
            athlete.showInfo();
            athlete.train();
            System.out.println("---------------------------");
        }
    }
}
