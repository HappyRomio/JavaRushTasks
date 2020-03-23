package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        StringJoiner j = new StringJoiner(",");
        while (reader.ready()) {
            for(String s : reader.readLine().split(" ")){
                if(s.length()>6){
                    j.add(s);
                }
            }
        }
        reader.close();
        writer.write(j.toString());
        writer.close();


    }
}
