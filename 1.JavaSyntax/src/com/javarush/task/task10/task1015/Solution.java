package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] arr = new ArrayList[2];

       ArrayList<String> ls1 = new ArrayList<>();
       ArrayList<String> ls2 = new ArrayList<>();
        ls1.add("dsdsa");
        ls1.add("dsdsasadad");
        ls1.add("dsdsadsadasdas");
        ls2.add("22dsdsa");
        ls2.add("22dsdsasadad");
        ls2.add("22dsdsadsadasdas");
        arr[0] = ls1;
        arr[1] = ls2;
        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}