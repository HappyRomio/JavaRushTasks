package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String date = r.readLine();
        String patternIn = "yyyy-MM-dd";
        String patternOut = "MMM dd, yyyy";


        SimpleDateFormat f1 = new SimpleDateFormat(patternIn, new Locale("ENG","USA"));
        SimpleDateFormat f2 = new SimpleDateFormat(patternOut, new Locale("ENG","USA"));

        Date d = f1.parse(date);

        System.out.println(f2.format(d).toUpperCase());
    }
}
