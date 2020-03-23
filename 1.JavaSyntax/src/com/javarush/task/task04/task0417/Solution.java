package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());

        if (a==b && b==c) {
            System.out.print(a +" "+a +" " + a);
        } else {
            if (a==b) {
                System.out.print(a +" "+b);
            }
            if (a==c) {
                System.out.print(a +" "+c);
            }
            if (c==b) {
                System.out.print(c +" "+b);
            }
        }

    }
}