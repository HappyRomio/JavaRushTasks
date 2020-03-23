package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());

        if(a>0 && b>0){
            System.out.print(1);
        } else if(a<0 && b>0){
            System.out.print(2);
        } else if(a<0 && b<0){
            System.out.print(3);
        } else if(a>0 && b<0){
            System.out.print(4);
        }


    }
}
