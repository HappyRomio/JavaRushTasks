package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ZipInputStream zin = new ZipInputStream(new FileInputStream(args[1]));
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        ZipEntry entry;
        while ((entry = zin.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = zin.read(buffer)) != -1)
                byteArrayOutputStream.write(buffer, 0, count);
            map.put(entry.getName(), byteArrayOutputStream);
        }
        zin.close();
        boolean flag = false;
       try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(args[1]))) {
           String[] arg = args[0].split("/");

            StringJoiner path = new StringJoiner("/");
           for (Map.Entry<String, ByteArrayOutputStream> enty : map.entrySet()) {
               String []s = enty.getKey().split("/");
               if (!(arg[arg.length - 1]).equals(s[s.length-1])) {
                   zip.putNextEntry(new ZipEntry(enty.getKey()));
                   zip.write(enty.getValue().toByteArray());
                   zip.closeEntry();
               }else {
                   for(int i = 0; i <s.length; i ++){
                       path.add(s[i]);
                   }
                   zip.putNextEntry(new ZipEntry(path.toString()));
                   Path p = Paths.get(args[0]);
                   Files.copy(p, zip);
                   zip.closeEntry();
            flag = true;
               }
           }

        if(flag){
            zip.putNextEntry(new ZipEntry("new/"));
            zip.closeEntry();

        } else {
            zip.putNextEntry(new ZipEntry("new/"+arg[arg.length-1] ));
            Path p = Paths.get(args[0]);
            Files.copy(p, zip);
            zip.closeEntry();
        }
       }catch (Exception e){

       }



    }
}
