package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();

        s.add("мама");
        s.add("мыла");
        s.add("раму");

        s.add(1,"именно");
        s.add(3,"именно");
        s.add("именно");

        for(String s1 : s) {
            System.out.println(s1);
        }
    }
}
