package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 20; i ++) {
            set.add(i);
        }
    return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            Integer temp = it.next();
            if( temp >10) {
                it.remove();
            }
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
