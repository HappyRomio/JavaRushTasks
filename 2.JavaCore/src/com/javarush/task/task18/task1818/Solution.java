package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();
        String name3 = br.readLine();


        FileWriter fw1 = new FileWriter(name1);
        FileReader fr2 = new FileReader(name2);

        int b;
        while ((b=fr2.read() )!= -1) {
            fw1.write(b);
        }
        fr2.close();
        fw1.close();

        fw1 = new FileWriter(name1,true);
        FileReader fr3 = new FileReader(name3);


        while ((b=fr3.read() )!= -1) {
            fw1.write(b);
        }

        fr3.close();
        fw1.close();

    }
}
