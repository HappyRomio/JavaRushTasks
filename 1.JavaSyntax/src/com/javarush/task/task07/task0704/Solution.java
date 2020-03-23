package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] str = new int[10];
        for(int i =0; i < 10; i++) {
            str[i]=Integer.parseInt(r.readLine());
        }
        for(int i= 9 ; i >=0; i--) {
            System.out.println(str[i]);
        }
    }
}

