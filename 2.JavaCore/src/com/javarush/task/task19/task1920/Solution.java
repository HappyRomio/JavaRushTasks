package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
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
      Double max = Collections.max(map.values());


        map.forEach((a,b)-> {
            if (Math.abs(b-max) < 0.00001) {
                System.out.println(a);
            } else {
            }
        });

    }
}
