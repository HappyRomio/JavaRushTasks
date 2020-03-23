package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();

        BufferedReader in =  new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<Integer> ls = new ArrayList<>();
        String s;
        while((s=in.readLine() )!= null) {
            try {
                ls.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {

            }

        }

        in.close();

        Collections.sort(ls);
        for(int i: ls) {
            if(i%2==0 ) {
                System.out.println(i);
            }
        }

    }
}
