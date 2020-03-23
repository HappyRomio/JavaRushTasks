package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for(int i =0; i < 5; i++) {
            strings.add(r.readLine());
        }

        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));
        strings.add(0,strings.remove(strings.size()-1));

        for(String s : strings) {
            System.out.println(s);
        }
    }
}
