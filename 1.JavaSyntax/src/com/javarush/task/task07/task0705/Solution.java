package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] str = new int[20];
        for(int i =0; i < 20; i++) {
            str[i]=Integer.parseInt(r.readLine());
        }

        int[] s1 = new int[10];
        int[] s2 = new int[10];
        for(int i =0; i < 20; i++) {
            if(i <10) {
                s1[i] = str[i];
            } else {
                s2[i-10] = str[i];
            }
        }

        for(int i =0; i < 10; i++) {
            System.out.println(s2[i]);
        }

        }
}
