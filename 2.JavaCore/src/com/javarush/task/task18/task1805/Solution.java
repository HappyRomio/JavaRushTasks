package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileInputStream fi = new FileInputStream(fileName);
        Set<Integer> set = new HashSet<>();
        while(fi.available() > 0) {
            set.add(fi.read());
        }
        fi.close();

        ArrayList<Integer>  arr = new ArrayList<>(set);

        Collections.sort(arr);

        for(Integer i : arr){
            System.out.print(i + " ");
        }

    }
}
