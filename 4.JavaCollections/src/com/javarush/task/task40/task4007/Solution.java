package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        if(date.matches("^[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            calendar.setTime(simpleDateFormat.parse(date));
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK)==1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK)-1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("AM или PM: " + calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }

        if(date.matches("^[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4}$")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            calendar.setTime(simpleDateFormat.parse(date));
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK)==1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK)-1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }

        if(date.matches("^[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            calendar.setTime(simpleDateFormat.parse(date));
            System.out.println("AM или PM: " + calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }

    }
}
