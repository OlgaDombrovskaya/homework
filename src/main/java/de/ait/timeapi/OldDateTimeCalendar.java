package de.ait.timeapi;

import java.util.Calendar;
import java.util.Date;

public class OldDateTimeCalendar {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        long timeMilis = date.getTime();
        System.out.println(timeMilis);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(year);
        System.out.println(month);
    }
}
