package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("D:/log/"));

        for(Object ip : logParser.execute("get user for ip = \"127.0.0.1\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"")){
            System.out.println((String)ip);
        }


    }
}