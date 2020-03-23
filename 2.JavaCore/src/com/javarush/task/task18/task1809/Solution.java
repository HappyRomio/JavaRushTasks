package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();

        br.close();
        FileInputStream fi = new FileInputStream(fileName1);
        FileOutputStream fo1 = new FileOutputStream(fileName2);

        ArrayList<Integer> reverseByte = new ArrayList<>();
        while (fi.available()>0){
            reverseByte.add(fi.read());
        }
        fi.close();
        Collections.reverse(reverseByte);

        for(Integer i : reverseByte) {
            fo1.write(i);
        }

        fo1.close();

    }
}
