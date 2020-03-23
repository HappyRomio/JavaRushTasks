package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new LinkedList<>(Arrays.asList(new File(root).listFiles()));
        List<String> result = new ArrayList<>();
        while(queue.peek()!=null){
            if(!queue.peek().isDirectory()){
                result.add(queue.poll().getAbsolutePath());
            } else {
                File[] files = queue.poll().listFiles();
                if(files!=null) {
                    for (File f :files) {
                        queue.offer(f);
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
            for(String s : getFileTree("D:/")){
                System.out.println(s);
            }


    }
}
