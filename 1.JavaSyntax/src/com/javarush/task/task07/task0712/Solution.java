package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(r.readLine());
        }

        String min=strings.get(0), max=strings.get(0);

        for(int i = 0; i < 10; i++) {
            if(strings.get(i).length() < min.length()) {
                min = strings.get(i);
            } else if(strings.get(i).length() > max.length()) {
                max = strings.get(i);
            }
        }

        for (String s : strings) {
            if (s.equals(max)) {
                System.out.println(max);
                break;
            } else if (s.equals(min)) {
                System.out.println(min);
                break;
            }
        }
    }

}
