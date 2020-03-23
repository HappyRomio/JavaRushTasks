package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        TreeSet<Character> set = new TreeSet<>();
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        int letter;
        while(br.ready()){
            letter = br.read();
            if(letter>64 && letter <123) {
                if(letter < 91){

                    letter = letter+32;

                }
                set.add((char) letter);

            }

        }
        int count =0;
        for(Character c : set) {
            System.out.print(c);
            count++;
            if(count==5){
                break;
            }
        }

    }
}
