package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();


        FileReader fr1 = new FileReader(name1);
        FileReader fr2 = new FileReader(name2);


        ArrayList<Character> arr = new ArrayList<>();
        int b;
        while((b=fr1.read())!=-1){

            arr.add((char)b);

        }
        fr1.close();

        FileWriter fw1 = new FileWriter(name1);
        while ((b=fr2.read())!=-1) {
            fw1.write(b);
        }
        fr2.close();

        for(Character c : arr) {
            fw1.write(c);
        }

        fw1.close();
    }
}
