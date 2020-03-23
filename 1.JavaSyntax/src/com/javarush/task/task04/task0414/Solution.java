package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(r.readLine());

        if(i%400 == 0) {
        System.out.println("количество дней в году: 366");
        } else if (i%100 == 0) {
            System.out.println("количество дней в году: 365");
    } else if (i%4 == 0) {
            System.out.println("количество дней в году: 366");
        } else {
            System.out.println("количество дней в году: 365");
        }


    }
}