package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне1", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне0", dateFormat.parse("MAY 1 2012"));

        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {

        Iterator <Map.Entry<String,Date>>iter = map.entrySet().iterator();


        while(iter.hasNext()) {

            Map.Entry<String,Date> entr = iter.next();

            if(entr.getValue().getMonth()>=5 && entr.getValue().getMonth()<=7) {
                iter.remove();
            }
        }


    }

    public static void main(String[] args) throws ParseException, InterruptedException {

    }
}
