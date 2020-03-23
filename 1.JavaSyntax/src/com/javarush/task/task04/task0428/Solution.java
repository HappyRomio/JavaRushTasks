package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int count=0;
        int[] ms = new int[3];
        ms[0] = a;
        ms[1] = b;
        ms[2] = c;

        for(int i=0; i <=2; i++) {
            if(ms[i] > 0) {
                count++;
            }
        }

        switch(count) {
            case 0:
                System.out.print(0);
                break;
            case 1:
                System.out.print(1);
                break;
            case 2:
                System.out.print(2);
                break;
            case 3:
                System.out.print(3);
                break;
        }

    }
}
