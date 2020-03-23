package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        
        RandomAccessFile rf = new RandomAccessFile(args[0],"rw");
        
        //rf.seek(Integer.parseInt(args[1]));
        byte[] b = new byte[1024];
        rf.seek(Integer.parseInt(args[1]));
        rf.read(b,0,args[2].length());
        String s = new String(b).trim();
        System.out.println(s);
        if(s.equals(args[2])){
            rf.seek(rf.length());
            rf.write("true".getBytes());
        } else {
            rf.seek(rf.length());
            rf.write("false".getBytes());
        }

        rf.close();
        

    }
}
