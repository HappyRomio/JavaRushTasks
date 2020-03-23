package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        String[] dat = date.split(" ");
        date=dat[0].substring(0,3) + " " + dat[1] +" " +dat[2];
        DateFormat f = new SimpleDateFormat("MMM dd yyyy",new Locale("ENG","USA"));
        Date d1 = f.parse(date);
        Date d2 = f.parse("JAN" +" 01 "+dat[2]);



        return  (((d1.getTime() / (1000 * 60 * 60 * 24))+1)-(d2.getTime() / (1000 * 60 * 60 * 24))) % 2 ==0 ? false : true;
    }
}
