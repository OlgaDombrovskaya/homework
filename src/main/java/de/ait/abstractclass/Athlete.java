package de.ait.abstractclass;

/**
 * Класс Athlete представляет общего атлета с именем и уровнем опыта. Он служит как абстрактный базовый класс для конкретных типов атлетов.
 */
public abstract class Athlete {

    private String name;
    private int experience;

    public Athlete(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }
    /**
     * Возвращает имя атлета и уровень опыта
     */
    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    /**
     * Определяет абстрактный метод тренировки атлета. Должен быть реализован в подклассах.
     */
    public abstract void train();

    /**
     * Отображает информацию об атлете, включая имя и уровень опыта.
     */
    public void showInfo() {
        System.out.println("Name: " + name + " Experience: " + experience);
    }

}