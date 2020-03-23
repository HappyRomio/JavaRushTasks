package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);

        TreeMap<String, Double> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int rByte;
        while (fr.ready()) {

            if((char)(rByte=fr.read())!='\n'){
                sb.append((char)rByte);
            } else {
                map.merge(sb.toString().split(" ")[0],Double.parseDouble(sb.toString().split(" ")[1]),(a,b)->b+map.get(sb.toString().split(" ")[0]));
                sb.setLength(0);
            }
        }
        fr.close();
        map.merge(sb.toString().split(" ")[0],Double.parseDouble(sb.toString().split(" ")[1]),(a,b)->b+map.get(sb.toString().split(" ")[0]));
        map.forEach((a,b)-> System.out.println(a + " " + b));


    }
}
