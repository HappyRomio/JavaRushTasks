package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int nextNumber=0;
        int count = Integer.parseInt(reader.readLine());

        int i=0;
        while(i < count){
            if(i == 0) {
                maximum = Integer.parseInt(reader.readLine());
                i++;
            } else {
                nextNumber = Integer.parseInt(reader.readLine());
                if(nextNumber >maximum) {
                    maximum = nextNumber;
                }
                i++;
            }
        }



        System.out.println(maximum);


    }
}
