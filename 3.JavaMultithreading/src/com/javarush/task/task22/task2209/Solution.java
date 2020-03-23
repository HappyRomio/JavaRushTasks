package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br. close();
        br = new BufferedReader(new FileReader(fileName));
        List<String> ls = new ArrayList<>();
        while (br.ready()){
            for(String s : br.readLine().split(" ")){
                ls.add(s);
            }
        }
        br.close();
        String [] str = new String[ls.size()];
        for(int i = 0; i < ls.size();i ++){
            str[i] = ls.get(i);
        }
        StringBuilder result = getLine(str);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words){
    StringBuilder sb = new StringBuilder();
        if(words.length==0){
            return sb;
        }
        List<String> ls = new ArrayList<>(Arrays.asList(words));
        sb.append(ls.get(0));
        ls.remove(0);
            while(ls.size()>0){
                String temp = "";
                for(int i = 0; i < ls.size(); i ++){
                    temp  = ls.get(i);
                    if(temp.toLowerCase().charAt(0)==sb.charAt(sb.length()-1)){
                        sb.append(" ");
                        sb.append(temp);

                        break;
                    }

                    if(temp.toUpperCase().charAt(temp.length()-1)==sb.charAt(0)){
                        sb.insert(0," ");
                        sb.insert(0,temp);

                        break;
                    }
                }
                ls.remove(temp);
                temp="";
            }

            return sb;

    }
}
