package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        count(number);
        System.out.println("Even: "+even+" Odd: " + odd);

    }

    public static void count(int num) {

        if(num/10 != 0) {
            if(num%2 ==0) {
                even++;
            }else{
                odd++;
            }
            count(num/10);
        } else {
            if(num%2==0) {
                even++;
            }else{
                odd++;
            }
        }

    }
}
