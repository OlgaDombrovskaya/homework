package de.ait.homework43;

/*Вычисление разницы между двумя датами

Создайте два объекта LocalDate (например, дата рождения и текущая дата).
Подсчитайте, сколько дней, месяцев и лет между этими датами, используя Period.
Выведите результат в удобном формате, например:
Прошло N лет, M месяцев и D дней.*/

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDay = LocalDate.of(1976,11,20);

        // Используем Period для вычисления разницы между датами
        Period period = Period.between(birthDay, currentDate);

        System.out.println("Прошло " + period.getYears() + " лет, "
                + period.getMonths() + " месяцев и "
                + period.getDays() + " дней.");
    }
}
