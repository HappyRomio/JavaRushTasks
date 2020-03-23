package com.javarush.task.task39.task3908;

import java.util.HashSet;
import java.util.Set;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
           System.out.println( isPalindromePermutation("abcaacb"));
    }

    public static boolean isPalindromePermutation(String s) {
        int countLiter = 0;
        int countOdd = 0;
        if(s==null || s.length()==0){
            return false;
        }
        Set<Character> set = new HashSet<>();
        s=s.toLowerCase();
            if(s.length()%2==0){
                for(int i = 0 ; i < s.length(); i++){
                    if(!set.contains(s.charAt(i))) {
                        for (int j = 0; j < s.length(); j++) {

                            if (s.charAt(i) == s.charAt(j)) {
                                countLiter++;
                            }
                        }
                        set.add(s.charAt(i));
                    }
                    if(countLiter%2!=0){
                        return false;
                    }
                    countLiter = 0;
                }
            }else{
                for(int i = 0 ; i < s.length(); i++){
                    if(!set.contains(s.charAt(i))) {
                        for(int j = 0; j < s.length(); j++){
                            if(s.charAt(i)==s.charAt(j)){
                                countLiter++;
                            }
                        }
                        set.add(s.charAt(i));
                    }

                    if(countLiter%2!=0 && countLiter!=s.length()){
                        countOdd++;
                        if(countOdd>1){
                            return false;
                        }
                    }
                    countLiter = 0;
                }
            }
            return true;
    }
}
