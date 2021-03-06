package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i ++) {
            list.add(br.readLine());
        }

        ArrayList<String> result = doubleValues(list);
        for(String s : result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> list2 = new ArrayList<>();
        for(String s : list) {
            list2.add(s);
            list2.add(s);
        }

        return list2;
    }
}
