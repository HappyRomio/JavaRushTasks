package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        if(array!=null && array.length >1) {
            Arrays.sort(array);

            if(array.length %2 ==0){
               final int median = (array[array.length/2-1] + array[array.length/2]) / 2;
                Arrays.sort(array,(a,b) -> Math.abs(median-a) - Math.abs(median-b) );
            }else{
                final int median = array[array.length/2];
                Arrays.sort(array,(a,b) -> Math.abs(median-a) - Math.abs(median-b) );
            }
        }


        return array;
    }
}
