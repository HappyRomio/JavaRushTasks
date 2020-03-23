package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        ArrayList<String> ls = new ArrayList<>();

        for(int i =0 ; i < N; i++) {
            ls.add(reader.readLine());
        }

        for(int i = 0; i < M ; i++) {
            ls.add(ls.size()-1,ls.remove(0));
        }


        for(String s : ls) {
            System.out.println(s);
        }

    }
}
