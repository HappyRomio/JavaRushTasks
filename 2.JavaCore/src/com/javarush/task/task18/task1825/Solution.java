package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int count = 1;
        String fileName = br.readLine();
        if(!fileName.equals("end")) {
            while (!br.readLine().equals("end")) {
                count++;
            }
        }

        br.close();
        String[] template = fileName.split("\\.");

            fileName = template[0] + "." + template[1];


        BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));

        for(int i = 1; i <=count; i ++){
            BufferedReader partReader = new BufferedReader(new FileReader(fileName+".part"+i));
            if(i>1){
                while (partReader.ready()){
                    wr.write(partReader.readLine());
                }
            } else {
                while (partReader.ready()){
                    wr.append(partReader.readLine());
                }
            }
            partReader.close();
        }

        wr.close();

    }
}
