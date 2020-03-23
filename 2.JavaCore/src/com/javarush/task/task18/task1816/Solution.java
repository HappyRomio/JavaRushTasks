package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

        public static String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        int lit;
        int count= 0;
        while((lit = fr.read())!=-1) {
                if(alphabet.contains(String.valueOf((char)lit))) {
                    count++;
                }
        }
        fr.close();
      System.out.print(count);


    }
}
