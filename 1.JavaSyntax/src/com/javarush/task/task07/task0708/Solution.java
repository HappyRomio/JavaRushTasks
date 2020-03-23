package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();
        int max=0;
        for(int i =0; i < 5; i++) {
            strings.add(r.readLine());
        }

        for(String s : strings) {
            if(s.length() > max) {
                max = s.length();
            }
        }

        for(String s : strings) {
            if(s.length()==max) {
                System.out.println(s);
            }
        }


    }
}
