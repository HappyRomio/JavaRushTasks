package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        System.out.println(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");


        if(FileUtils.isExist(resultFileAbsolutePath)){
            FileUtils.renameFile(resultFileAbsolutePath,new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt"));
        }
        resultFileAbsolutePath = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        ArrayList<File >map = new ArrayList<>();
        makeFileTree(file, map);
        Collections.sort(map, Comparator.comparing(File::getName));
        FileWriter fw = new FileWriter(resultFileAbsolutePath);
        for(File f : map){
            FileReader fr = new FileReader(f);
            while(fr.ready()){
                fw.write(fr.read());
            }
            fw.write('\n');
            fr.close();
        }

        fw.close();





    }

    public static void makeFileTree (File path,  ArrayList<File >files ) {
        File[] f = path.listFiles();
        if (f != null) {
            for (File file : f) {
                if (file.isDirectory()) {
                    makeFileTree(file, files);
                } else {
                    if(file.length() <=50) {
                        files.add(file);
                    }
                }
            }
        }
    }
}
