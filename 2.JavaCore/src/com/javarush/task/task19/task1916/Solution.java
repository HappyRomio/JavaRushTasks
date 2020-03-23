package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader br2 = new BufferedReader(new FileReader(fileName2));

        String s1="";
        String s2=null;
        String s3="";

        int count = 0;

        boolean lastTypeSame = false;

       while(br1.ready()) {
               s1 = br1.readLine();
               if(count==0) {
                   s2 = br2.readLine();
               }
                count++;
           if (s1.equals(s2)) {
               if(s1!=null) {
                   lines.add(new LineItem(Type.SAME, s1));
               }
               s2 = br2.readLine();
               lastTypeSame = true;
           } else {
                   s3 = br2.readLine();
               if (s1.equals(s3)) {
                   if(s2 != null) {
                       lines.add(new LineItem(Type.ADDED, s2));
                   }
                   if(s3 != null) {
                       lines.add(new LineItem(Type.SAME,s3));
                   }
                   s2=br2.readLine();
                   lastTypeSame = false;
               } else {
                   if(s1 != null) {
                       lines.add(new LineItem(Type.REMOVED, s1));
                   }
                   s1 = br1.readLine();
                   if(s1 != null) {
                       lines.add(new LineItem(Type.SAME, s1));
                   }
                    s2=s3;
                   lastTypeSame = false;
               }
           }
       }
       if(lastTypeSame = true && s2!= null &&!s1.equals(s2)) {
           lines.add(new LineItem(Type.ADDED, s2));

       }

        br1.close();
        br2.close();

        for(LineItem i : lines){
            System.out.println(i.type + " " + i.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
