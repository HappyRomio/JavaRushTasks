package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName);
        int count =0;
        while(fi.available() > 0) {
           if(fi.read() == 44) {
               count++;
           }
        }
        fi.close();

        System.out.print(count);

    }
}
