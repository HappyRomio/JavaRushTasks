package com.javarush.task.task39.task3910;

import java.beans.IntrospectionException;
import java.util.HashSet;

/*
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
            System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(12));
        System.out.println(isPowerOfThree(81));
    }

    public static boolean isPowerOfThree(int n) {

        HashSet<Long> set = new HashSet<>();
        long i = 3;
        set.add(1L);
        set.add(3L);
        while (i< Integer.MAX_VALUE){
            i *=3;
            set.add(i);
        }

        if (set.contains((long)n)) {
            return true;
        }
        return false;
    }
}
