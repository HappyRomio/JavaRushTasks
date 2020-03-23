package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 1;
        StringBuilder string = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i < s.length(); i++) {
                if (string.indexOf(String.valueOf(s.charAt(i))) != -1) {
                    if(string.length() > max)
                    max = string.length();
                    string.setLength(0);
                    string.append(s.charAt(i));
                } else {
                    string.append(s.charAt(i));
                }
            }
        }
            return max > string.length() ? max : string.length();

    }
}
