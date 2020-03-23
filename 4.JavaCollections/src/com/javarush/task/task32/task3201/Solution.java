package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(args[0],"rw");
        if(Integer.parseInt(args[1]) < rf.length()) {
            rf.seek(Integer.parseInt(args[1]));
            rf.write(args[2].getBytes());
        } else {
            rf.seek(rf.length());
            rf.write(args[2].getBytes());
        }

    }
}
