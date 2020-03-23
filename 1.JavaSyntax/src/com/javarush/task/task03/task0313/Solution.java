package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        String[] mmr = {"Мама", "Мыла","Раму"};
        System.out.println(mmr[0]+mmr[1]+mmr[2]);
        System.out.println(mmr[0]+mmr[2]+mmr[1]);
        System.out.println(mmr[1]+mmr[2]+mmr[0]);
        System.out.println(mmr[1]+mmr[0]+mmr[2]);
        System.out.println(mmr[2]+mmr[0]+mmr[1]);
        System.out.println(mmr[2]+mmr[1]+mmr[0]);

    }
}
