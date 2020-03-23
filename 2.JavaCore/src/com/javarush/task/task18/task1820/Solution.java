package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();
        br.close();
        BufferedReader fr = new BufferedReader(new FileReader(name1));
        BufferedWriter wr = new BufferedWriter(new FileWriter(name2));

        DecimalFormat dc = new DecimalFormat("#");
        dc.setRoundingMode(RoundingMode.HALF_UP);
        String line = fr.readLine();
        String [] nums = line.split(" ");
        fr.close();
        for(String num : nums) {
            if (Double.parseDouble(num) > 0) {
                dc.setRoundingMode(RoundingMode.HALF_UP);
                wr.write(String.valueOf(dc.format(Double.parseDouble(num))) + " ");
            } else {
                dc.setRoundingMode(RoundingMode.HALF_DOWN);
                wr.write(String.valueOf(dc.format(Double.parseDouble(num))) + " ");
            }
        }

        wr.close();
    }
}
