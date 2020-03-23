package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());

        for(int i = 0; i < a ; i++) {
            for(int j = 0; j < b; j ++) {
                System.out.print("8");
            }
            System.out.println();
        }

    }
}
