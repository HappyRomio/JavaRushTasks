package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Сталлоне1", "Сталлоне1");
        map.put("Сталлоне2", "Сталлоне12");
        map.put("Сталлоне3", "Сталлоне13");
        map.put("Сталлоне4", "Сталлоне14");
        map.put("Сталлоне5", "Сталлоне15");
        map.put("Сталлоне6", "Сталлоне16");
        map.put("Сталлоне7", "Сталлоне17");
        map.put("Сталлоне8", "Сталлоне18");
        map.put("Сталлоне9", "Сталлоне18");
        map.put("Сталлоне0", "Сталлоне17");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> fm = new ArrayList<>();
        for(Map.Entry<String,String> e : map.entrySet()){
            fm.add(e.getValue());
        }

        for(String a : fm) {
            if(Collections.frequency(fm,a) > 1) {
                removeItemFromMapByValue(map,a);
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
