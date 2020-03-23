package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer s = new StringTokenizer(query,delimiter);
        String [] tokens = new String[s.countTokens()];
        for(int i = 0 ; i < tokens.length; i++){
            tokens[i] = s.nextToken();
        }
        return tokens;
    }
}
