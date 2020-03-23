package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {

    private Path path;

    public FileBucket()  {
        try {
            path = Files.createTempFile(Helper.generateRandomString(), ".tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (Exception e){

        }
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch(Exception e){
            return 0;
        }
    }

    public void putEntry(Entry entry){
        try {
            OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(entry);
            out.close();
            outputStream.close();
        }catch(Exception e ){

        }
    }

   public Entry getEntry(){
        Entry e = null;
        try {
            InputStream inputStream = Files.newInputStream(path);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            if (getFileSize() != 0) {
            e = (Entry)in.readObject();
                }
                return e;
        }catch (Exception ex){

        }
        return  null;
    }

   public void remove(){
        try {
            Files.delete(path);
        } catch (Exception e){

        }
    }

}
