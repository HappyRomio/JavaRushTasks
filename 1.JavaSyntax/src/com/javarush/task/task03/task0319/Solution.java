package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String name = read.readLine();
        int num1 = Integer.parseInt(read.readLine());
        int num2 = Integer.parseInt(read.readLine());


        System.out.println(name + " получает " + num1 + " через " + num2 +" лет.");

    }
}
