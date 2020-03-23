package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        double sum=0;
        double count =0;
        while (true) {
            int number = Integer.parseInt(r.readLine());
            if ( number != -1) {
                sum+=number;
                count++;
            } else{
                break;
            }
        }

        System.out.println(sum/count);
    }
}

