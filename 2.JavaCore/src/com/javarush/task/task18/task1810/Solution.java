package com.javarush.task.task18.task1810;

/* 
DownloadException
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        FileInputStream fi = null;

        while (true) {
            fileName1 = br.readLine();

            fi = new FileInputStream(fileName1);
            if (fi.available() < 1000) {
                fi.close();
                throw new DownloadException();
            }

        }

    }


    public static class DownloadException extends Exception {

    }
}
