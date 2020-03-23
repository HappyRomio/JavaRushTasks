package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(fileName));
        int count = 0;

        while(br.ready()){
            String temp = br.readLine();
            for(String str : words) {
             count+= Collections.frequency(Arrays.asList(temp.split(" ")),str);
            }
            if(count==2){
                System.out.println(temp);
                count=0;
            } else {
                count = 0;
            }
        }

        br.close();


    }
}
