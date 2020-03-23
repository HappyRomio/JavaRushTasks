package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Сталлоне1", "Сталлоне1");
        map.put("Сталлоне2", "Сталлоне12");
        map.put("Сталлоне3", "Сталлоне13");
        map.put("Сталлоне3", "Сталлоне13");
        map.put("Сталлоне5", "Сталлоне15");
        map.put("Сталлоне6", "Сталлоне16");
        map.put("Сталлоне7", "Сталлоне17");
        map.put("Сталлоне8", "Сталлоне18");
        map.put("Сталлоне9", "Сталлоне18");
        map.put("Сталлоне0", "Сталлоне17");
        return map;

    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
