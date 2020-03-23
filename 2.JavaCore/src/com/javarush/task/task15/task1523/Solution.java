package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    Solution(){};
    public Solution(Solution s){};
    protected Solution(int a){};
    private Solution(int a , int b){};
    public static void main(String[] args) {

    }
}

