package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String inFileName = bf.readLine();


        InputStream i = new FileInputStream(inFileName);


        while(i.available() >0){

            System.out.print((char)i.read());
        }

        i.close();
        bf.close();
    }
}