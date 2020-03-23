package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        String [] words;
        boolean match= false;
        while(fileReader.ready()){
            words = fileReader.readLine().split(" ");
            for(String s : words){
                match = s.matches("(\\D*\\d+\\D*)+");
                if(match){
                        fileWriter.write(s+ " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
