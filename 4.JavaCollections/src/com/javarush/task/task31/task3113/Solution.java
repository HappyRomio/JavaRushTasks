package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor {

    private int countFiles = 0;
    private int countDirectorys = 0;
    private int lengthAll = 0;

    public int getCountFiles() {
        return countFiles;
    }

    public int getCountDirectorys() {
        return countDirectorys;
    }

    public int getLengthAll() {
        return lengthAll;
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(br.readLine());

        Solution s = new Solution();


        if(Files.isDirectory(path)){
            Files.walkFileTree(path,s);
            System.out.println("Всего папок - " + (s.getCountDirectorys()-1));
            System.out.println("Всего файлов - " + s.getCountFiles());
            System.out.println("Общий размер - " + s.getLengthAll());
        } else {
            System.out.println(path.toString()+ " - не папка");
        }
    }


    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        System.out.println(((Path)file).toString() + " " + Files.isDirectory((Path)file));
            countFiles++;
            lengthAll+=Files.readAllBytes((Path)file).length;

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        countDirectorys++;
        return FileVisitResult.CONTINUE;
    }
}
