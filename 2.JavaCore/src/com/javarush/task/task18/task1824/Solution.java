package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

            try
            {
                while (true) {
                    fileName = br.readLine();
                    FileInputStream f = new FileInputStream(fileName);
                    f.close();
                }

            }catch(FileNotFoundException e){
                System.out.println(fileName);
                br.close();
            }
    }
}
