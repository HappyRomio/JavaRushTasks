package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int d = Integer.parseInt(r.readLine());

        if (a==b && a==c && a == d) {
            System.out.println(a);
        } else if (a > b && a> c&& a>d){
            System.out.println(a);
        } else if (b >= a &&  b >= c&& b>=d){
            System.out.println(b);
        } else if (c >=a &&  c >= b && c >= d) {
            System.out.println(c);
        }else if (d >= a &&  d >= b && d >= c) {
            System.out.println(d);
        }
    }
}
