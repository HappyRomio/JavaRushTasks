package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        while (true) {
            int number = Integer.parseInt(r.readLine());
            if ( number != -1) {
                sum+=number;
            } else{
                break;
            }
        }

        System.out.println(sum-1);

    }
}
