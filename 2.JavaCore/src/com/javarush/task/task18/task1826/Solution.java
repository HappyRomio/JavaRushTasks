package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) {
            BufferedReader br = new BufferedReader(new FileReader(args[1]));
            BufferedWriter wr = new BufferedWriter(new FileWriter(args[2]));
            while (br.ready()) {
                wr.write(br.read() * 2);
            }
            br.close();
            wr.close();
        } else {
            BufferedReader br = new BufferedReader(new FileReader(args[1]));
            BufferedWriter wr = new BufferedWriter(new FileWriter(args[2]));
            while (br.ready()) {
                wr.write(br.read() / 2);
            }
            br.close();
            wr.close();

        }
    }

}
