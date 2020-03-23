package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        br.close();

        FileReader fr = new FileReader(fileName1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (fr.ready()){
            sb.append((char)fr.read());
        }
        fr.close();
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
