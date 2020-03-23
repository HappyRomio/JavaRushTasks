package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader( new FileReader(fileName1));
        BufferedWriter wr= new BufferedWriter(new FileWriter(fileName2));

        StringBuilder sb = new StringBuilder();
        while (fr.ready()){
            sb.append((char)fr.read());
        }
        fr.close();
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) {
            wr.write(matcher.group()+" ");
        }
        wr.close();
    }
}
