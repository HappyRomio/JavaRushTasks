package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            arr.add(Integer.parseInt(reader.readLine()));
        }
        arr.sort( (Integer a, Integer b) -> a.compareTo(b));
        for(Integer a : arr) {
            System.out.println(a);
        }
    }
}
