package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> str = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            str.add(args[i]);
        }

        Collections.sort(str,(a,b) -> {
            String [] s1 = a.split("\\.");
            String [] s2 = b.split("\\.");
            return Integer.parseInt(s1[s1.length-1]) > Integer.parseInt(s2[s2.length-1]) ? 1 : -1;
        });
        List<FileInputStream> ls = new ArrayList<>();
        for(String s : str) {
        ls.add(new FileInputStream(s));
        }
        ByteArrayOutputStream all = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
        ZipInputStream zin = new ZipInputStream(new SequenceInputStream(Collections.enumeration(ls)));
        try {

            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = zin.read(buffer)) != -1) {
                System.out.println(count);
                all.write(buffer, 0, count);

            }


            fileOutputStream.write(all.toByteArray());

        } finally {
            zin.close();
            all.close();
            fileOutputStream.close();
        }
    }
}
