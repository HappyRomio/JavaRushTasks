package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Сталлоне1", 1);
        map.put("Сталлоне2", 2);
        map.put("Сталлоне3", 3);
        map.put("Сталлоне4", 5);
        map.put("Сталлоне5", 666);
        map.put("Сталлоне6", 7777);
        map.put("Сталлоне7", 45);
        map.put("Сталлоне8", 18);
        map.put("Сталлоне9", 19);
        map.put("Сталлоне0", 20);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue()<500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}