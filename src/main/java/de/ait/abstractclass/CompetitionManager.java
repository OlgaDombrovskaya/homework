package de.ait.abstractclass;

import java.util.ArrayList;
import java.util.List;

public class CompetitionManager {
    public static void main(String[] args) {

        // Создание списка для хранения соревнований
        List<Competition> competitionList = new ArrayList<>();

        // Добавление соревнований в список
        competitionList.add(new Marathon("Марафон"));
        competitionList.add(new SwimmingChampionship("Чемпионат по плаванию"));

        // Итерация по списку, отображение информации и запуск каждого соревнования
        for (Competition competition : competitionList) {
            competition.showCompetitionInfo();
            competition.startCompetition();
            System.out.println("---------------------------");
        }
    }
}
