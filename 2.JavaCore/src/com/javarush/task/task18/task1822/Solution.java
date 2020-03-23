package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();
        br.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = reader.readLine()) != null) {
            if(line.split(" ")[0].equals(args[0])){
                System.out.println(line);
            }
        }
        reader.close();

    }
}
