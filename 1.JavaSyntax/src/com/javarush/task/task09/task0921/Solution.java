package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> i = new ArrayList<>();

        try{
        while(true) {


            i.add(Integer.parseInt(r.readLine()));
        }
        } catch (NumberFormatException | IOException e) {
            for(Integer in : i) {
                System.out.println(in);
            }
        }


    }
}
