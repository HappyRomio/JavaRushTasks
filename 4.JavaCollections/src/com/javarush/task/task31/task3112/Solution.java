package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {

        InputStream is = new URL(urlString).openStream();

        Path tempFile = Files.createTempFile("","");
        Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
        is.close();
        String s [] = urlString.split("/");
        Files.move(tempFile,Paths.get(downloadDirectory.toString() +"/" + s[s.length-1]), StandardCopyOption.REPLACE_EXISTING);

        return Paths.get(downloadDirectory.toString() +"/" +  s[s.length-1]);
    }
}
