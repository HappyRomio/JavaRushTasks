package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int countPlus=0;
        int countMinus=0;
        int[] ms = new int[3];
        ms[0] = a;
        ms[1] = b;
        ms[2] = c;

        for(int i=0; i <=2; i++) {
            if(ms[i] > 0) {
                countPlus++;
            } else if (ms[i] < 0) {
                countMinus++;
            }
        }
        System.out.println("количество отрицательных чисел: " + countMinus);
        System.out.println("количество положительных чисел: " + countPlus);

    }
}
