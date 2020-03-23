package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i ++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        Collections.reverse(list);
        for(Integer s : list) {
            System.out.println(s);
        }

        //напишите тут ваш код
    }
}
