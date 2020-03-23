package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        FileReader fr = new FileReader(fileName1);
        FileWriter wr= new FileWriter(fileName2);
        boolean flag=false;
        while (fr.ready()){
            if(flag){
                wr.write(fr.read());
                flag=false;
            } else {
                fr.read();
                flag=true;
            }
        }

        fr.close();
        wr.close();

    }
}
