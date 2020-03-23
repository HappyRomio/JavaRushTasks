package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        int[] chars = new int[256];

        while (in.available()>0){
            chars[in.read()]++;
        }
        in.close();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                System.out.println((char) i + " " + chars[i]);
            }
        }




    }
}
