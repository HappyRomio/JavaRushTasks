package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for(int i =0; i < 5; i++) {
            strings.add(r.readLine());
        }
        int min=strings.get(0).length();

        for(String s : strings) {
            if(s.length() < min) {
                min = s.length();
            }
        }

        for(String s : strings) {
            if(s.length()==min) {
                System.out.println(s);
            }
        }
    }
}
