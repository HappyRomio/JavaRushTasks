package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName=br.readLine()).equals("exit")){
            ReadThread rt = new ReadThread(fileName);
            rt.start();
        }
        for(Map.Entry<String,Integer> entry : resultMap.entrySet()){
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
        br.close();

    }

    public static class ReadThread extends Thread  {
        private BufferedReader br;
        private String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            this.fileName = fileName;
        }

        @Override
        public void run() {
            HashMap<Integer,Integer> map = new HashMap<>();
            int word;
            while(true){
                try {
                    if (!br.ready()) break;
                    word = br.read();
                    map.put(word,map.getOrDefault(word, 0) +1);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int max = Collections.max(map.values());
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue()==max){
                    resultMap.put(fileName,entry.getKey());
                    break;
                }
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
