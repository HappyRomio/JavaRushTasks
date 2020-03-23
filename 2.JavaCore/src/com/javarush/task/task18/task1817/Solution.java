package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        int lit;
        double count_spaces= 0;
        double count_others= 0;
        while((lit = fr.read())!=-1) {
            if((char)lit == ' ') {
                count_spaces++;
            }
                count_others++;

        }
        fr.close();
        DecimalFormat dc = new DecimalFormat("#.##");
        dc.setRoundingMode(RoundingMode.CEILING);
        System.out.print(dc.format(count_spaces/count_others*100));
    }
}
