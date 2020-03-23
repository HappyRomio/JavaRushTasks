package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings.add("мера");
        strings.add("вода");
        strings.add("упор");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {

        Iterator<String> iter = strings.iterator();
        ArrayList<String> ls = new ArrayList<>();

        while(iter.hasNext()) {
            String temp = iter.next();
            if (!(temp.contains("р") && temp.contains("л"))) {
                if (temp.contains("р")) {
                } else if(temp.contains("л")){
                    ls.add(temp);
                    ls.add(temp);
                }else {
                    ls.add(temp);
                }
            } else {
                ls.add(temp);
            }

        }

        return ls;
    }
}