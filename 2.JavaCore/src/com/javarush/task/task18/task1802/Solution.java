package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName);
        int max = fi.read();
        int b;
        while(fi.available() > 0) {
            b=fi.read();
            if(b<max)
                max=b;
        }
        fi.close();
        System.out.println(max);
    }
}
