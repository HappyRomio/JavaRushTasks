package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> ls = new ArrayList<>();
        String r;
        while(!(r=reader.readLine()).equals("end")){
            ls.add(r);
        }

        for(String s : ls) {
            System.out.println(s);
        }

    }
}