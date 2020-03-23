package com.javarush.task.task08.task0815;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<>();

        for(int i = 0 ; i < 10; i++) {
            map.put("Surnaeme" +i,"Name" +i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        return Collections.frequency(map.values(),name);

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        return Collections.frequency(map.keySet(),lastName);

    }

    public static void main(String[] args) {

    }
}
