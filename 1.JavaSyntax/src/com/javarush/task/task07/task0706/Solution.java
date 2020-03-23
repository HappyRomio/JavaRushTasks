package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int[] str = new int[15];
        int env=0, odd=0;
        for(int i =0; i < 15; i++) {
            if(i%2==0){
                str[i]=Integer.parseInt(r.readLine());
                env+=str[i];
            }else {
                str[i]=Integer.parseInt(r.readLine());
                odd+=str[i];
            }
        }
                if (env > odd) {
             System.out.println("В домах с четными номерами проживает больше жителей.");
                } else {
                    System.out.println("В домах с нечетными номерами проживает больше жителей.");
                }

        }

    }

