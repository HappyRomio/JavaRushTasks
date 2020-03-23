package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String line;

       while(!(line = br.readLine()).equals("exit")) {
           if(line.contains(".")){
               try {
                   print(Double.parseDouble(line));
               } catch (Exception e) {
               print(line);
           }
           } else {
               try {
                   int i = Integer.parseInt(line);
                   if (i>0 && i< 128) {
                    print((short)i);
                   } else {
                       print(i);
                   }
               } catch (Exception e) {
                   print(line);
               }
           }

       }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
