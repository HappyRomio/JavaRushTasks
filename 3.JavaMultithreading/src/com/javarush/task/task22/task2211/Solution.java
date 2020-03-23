package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), Charset.forName("windows-1251")));
       BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), Charset.forName("UTF-8")));

       while(br.ready()){
           wr.write(br.readLine());
       }
       br.close();
       wr.close();

    }
}
