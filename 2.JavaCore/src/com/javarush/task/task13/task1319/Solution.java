package com.javarush.task.task13.task1319;

import javax.swing.*;
import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();

        BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));

        while(true){
            String line = br.readLine();
            if(!line.equals("exit")){
                wr.write(line);
                wr.newLine();
            } else {
                wr.write(line);
                break;
            }
        }
        wr.close();

    }
}
