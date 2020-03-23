package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> strings = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            strings.add(Integer.parseInt(r.readLine()));
        }

        ArrayList<Integer> s1 = new ArrayList<>();
        ArrayList<Integer> s2 = new ArrayList<>();
        ArrayList<Integer> s3 = new ArrayList<>();

        for(Integer s : strings) {
            if(s%3==0) {
                s1.add(s);
            }
            if(s%2==0) {
                s2.add(s);
            }
            if(s%2!=0 && s%3!=0 ) {
                s3.add(s);
            }
        }

        printList(s1);
        printList(s2);
        printList(s3);

    }

    public static void printList(ArrayList<Integer> list) {
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
