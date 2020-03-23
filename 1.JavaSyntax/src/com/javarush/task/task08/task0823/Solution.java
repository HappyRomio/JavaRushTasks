package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        String result = "";
        string = string.trim().replaceAll("\\s+", " ");
        String[] sp = string.split(" ");
        for(int i = 0; i < sp.length-1; i++) {
            result += sp[i].substring(0,1).toUpperCase() + sp[i].substring(1) + " ";
        }
        result += sp[sp.length-1].substring(0,1).toUpperCase() + sp[sp.length-1].substring(1);

        System.out.println(result);
    }
}
