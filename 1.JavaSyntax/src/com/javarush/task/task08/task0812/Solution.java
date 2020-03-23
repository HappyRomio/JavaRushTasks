package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       List<Integer> ls = new ArrayList<>();
       for(int i=0; i <10; i++) {
           ls.add(Integer.parseInt(br.readLine()));
       }
       int num=ls.get(0);
       int count1=0, count2=0;
       for(int i = 0; i < 10; i ++) {
           if(ls.get(i) == num) {
               count1++;
           } else {
               if(count1 > count2){
               count2=count1;
               count1=1;
               num = ls.get(i);
               } else {
                   count1=1;
                   num = ls.get(i);
               }
           }
       }

       System.out.println(count2 >count1 ? count2:count1);


    }
}