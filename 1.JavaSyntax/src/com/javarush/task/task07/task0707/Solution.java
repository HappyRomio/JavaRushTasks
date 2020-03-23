package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<>();
        ls.add("1");
        ls.add("14");
        ls.add("3");
        ls.add("2");
        ls.add("23");

        System.out.println(ls.size());

        for(String s : ls) {
            System.out.println(s);
        }
    }
}
