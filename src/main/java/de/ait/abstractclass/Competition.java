package de.ait.abstractclass;

public abstract class Competition {
    private String competitionName;

    public Competition(String competitionName) {
        this.competitionName = competitionName;
    }

    public abstract void startCompetition();

    public void showCompetitionInfo() {
        System.out.println("Competition: " + competitionName);
    }
}
