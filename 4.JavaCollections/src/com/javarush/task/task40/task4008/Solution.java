package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;


/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("9.10.2017");
        System.out.println();
        printDate("5:56:45");
    }

    public static void printDate(String date) {


        if(date.matches("^[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$")){
            LocalDate localDate = LocalDate.parse(date.split(" ")[0],DateTimeFormatter.ofPattern("d.M.y"));
            LocalTime localTime = LocalTime.parse(date.split(" ")[1],DateTimeFormatter.ofPattern("H:m:s"));
            System.out.println("День: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + localDate.get(ChronoField.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + (localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH )));
            System.out.println("Неделя года: " + (localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR)));
            System.out.println("Месяц: " + localDate.get(ChronoField.MONTH_OF_YEAR));
            System.out.println("Год: " + localDate.get(ChronoField.YEAR));
            System.out.println("AM или PM: " +  (localTime.get(ChronoField.AMPM_OF_DAY)==1?"PM" : "AM"));
            System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());

        }

        if(date.matches("^[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4}$")){
            LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("d.M.y"));
            System.out.println("День: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + localDate.get(ChronoField.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + (localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH )));
            System.out.println("Неделя года: " + (localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR)));
            System.out.println("Месяц: " + localDate.get(ChronoField.MONTH_OF_YEAR));
            System.out.println("Год: " + localDate.get(ChronoField.YEAR));
        }

        if(date.matches("^[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$")){
            DateTimeFormatter  dateFormat = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime localTime = LocalTime.parse(date, dateFormat);
            System.out.println("AM или PM: " +  (localTime.get(ChronoField.AMPM_OF_DAY)==1?"PM" : "AM"));
            System.out.println("Часы: " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());

        }
    }
}
