package de.ait.abstractclass;

public class SwimmingChampionship extends Competition {

    public SwimmingChampionship(String competitionName) {
        super(competitionName);
    }

    @Override
    public void startCompetition() {
        System.out.println("Чемпионат по плаванию начался! Участники плывут 100 метров.");
    }
}
