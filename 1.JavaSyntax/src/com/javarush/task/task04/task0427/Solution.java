package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());
        int count=0;
        String chet;
        if(a>=1 && a < 1000) {
            if (a % 2 == 0) {
                chet = "четное";
            } else {
                chet = "нечетное";
            }

            for (int i = 0; i < 2; i++) {
                if (a / 10 != 0) {
                    count++;
                    a = a / 10;
                }
            }

            if (count == 0) {
                System.out.print(chet + " однозначное число");
            } else if (count == 1) {
                System.out.print(chet + " двузначное число");
            } else if (count == 2) {
                System.out.print(chet + " трехзначное число");
            }
        }
    }
}
