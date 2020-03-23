package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static {

        try {
            firstFileName = br.readLine();
            secondFileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();
        void join() throws InterruptedException;

        void start();
    }


    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String content = "";

        @Override
        public void setFileName(String fullFileName) {
            firstFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return content;
        }


        @Override
        public void run() {
            try {
                br = new BufferedReader(new FileReader(firstFileName));
                String s;
                while((s=br.readLine())!=null){
                    content += s +" ";
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //add your code here - добавьте код тут
}
