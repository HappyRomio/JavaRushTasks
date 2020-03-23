package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(name));

        while (br.ready()) {
            StringBuilder sb = new StringBuilder(br.readLine());
            System.out.println(sb.reverse().toString());
        }

        br.close();


    }
}
