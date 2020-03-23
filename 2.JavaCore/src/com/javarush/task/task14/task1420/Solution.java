package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            Integer first = Integer.parseInt(br.readLine());
            if(first <= 0) throw new Exception();
            Integer second = Integer.parseInt(br.readLine());
            if(second <= 0) throw new Exception();
            int min = first >= second ? second : first;
            for (int i = min; i > 0; i--) {
                if (first % i == 0 && second % i == 0) {
                    System.out.print(i);
                    break;
                }
            }


    }
}
