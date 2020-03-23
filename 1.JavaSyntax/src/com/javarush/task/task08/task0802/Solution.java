package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        Map<String, String> hMap = new HashMap<String,String>();


        hMap.put("арбуз","ягода");
        hMap.put("банан","трава");
        hMap.put("вишня","ягода");
        hMap.put("груша","фрукт");
        hMap.put("дыня","овощ");
        hMap.put("ежевика","куст");
        hMap.put("жень-шень","корень");
        hMap.put("земляника","ягода");
        hMap.put("ирис","цветок");
        hMap.put("картофель","клубень");

        for(Map.Entry<String,String> entry : hMap.entrySet()) {
            System.out.println(entry.getKey() + " - "+ entry.getValue());
        }


    }
}
