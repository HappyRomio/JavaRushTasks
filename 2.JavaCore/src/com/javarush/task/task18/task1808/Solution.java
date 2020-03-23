package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        String fileName3 = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName1);
        FileOutputStream fo1 = new FileOutputStream(fileName2);
        FileOutputStream fo2 = new FileOutputStream(fileName3);


        boolean firstFile = fi.available() %2 ==0 ? true : false;
        int middle = (fi.available()/2);

        while (fi.available()>middle){
                fo1.write(fi.read());
        }
    fo1.close();
        while (fi.available()>0){
                fo2.write(fi.read());
        }
            fo2.close();
            fi.close();

    }
}
