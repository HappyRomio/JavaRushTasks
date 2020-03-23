package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String name = r.readLine();
        int age = Integer.parseInt(r.readLine());

        if (age > 20) {
            System.out.print("И 18-ти достаточно");
        }
    }
}
