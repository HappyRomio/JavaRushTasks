package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(r.readLine())%5;
        if (a>=0 && a<3) {
            System.out.println("зелёный");
        }else if (a>=3 && a < 4){
            System.out.println("желтый");
        }else {
            System.out.println("красный");
        }



    }
}