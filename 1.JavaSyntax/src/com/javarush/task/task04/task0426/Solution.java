package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());

        if(a == 0) {
            System.out.print("ноль");
        } else if (a<0 && a%2==0) {
            System.out.print("отрицательное четное число");
        } else if (a<0 && a%2!=0) {
            System.out.print("отрицательное нечетное число");
        }
        else if (a>0 && a%2!=0) {
            System.out.print("положительное нечетное число");
        }
        else if (a>0 && a%2==0) {
            System.out.print("положительное четное число");
        }


    }
}
