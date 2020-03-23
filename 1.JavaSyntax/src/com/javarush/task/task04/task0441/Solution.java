package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int temp;
        int[] ms = new int[3];
        ms[0] = a;
        ms[1] = b;
        ms[2] = c;
        for (int i = 0; i < 2 ; i ++) {
            for (int j = 0; j <= 2 - 1; j++) {
                if(ms[j] >=ms[j+1]) {
                    temp = ms[j+1];
                    ms[j+1] = ms[j];
                    ms[j]=temp;
                }
            }
        }

        System.out.print(ms[1]);

    }
}
