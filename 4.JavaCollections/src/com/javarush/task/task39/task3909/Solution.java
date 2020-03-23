package com.javarush.task.task39.task3909;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {

        Assert.assertTrue(Solution.isOneEditAway("Флаг","Флаг"));
        Assert.assertTrue(Solution.isOneEditAway("",""));

        Assert.assertTrue(Solution.isOneEditAway("Фла","Флаг"));
        Assert.assertTrue(Solution.isOneEditAway("Флаг","Фла"));

        Assert.assertTrue(Solution.isOneEditAway("лаг","Флаг"));
        Assert.assertTrue(Solution.isOneEditAway("Флаг","лаг"));

        Assert.assertTrue(Solution.isOneEditAway("Флваг","Флаг"));
        Assert.assertTrue(Solution.isOneEditAway("Флаг","Флваг"));

        Assert.assertTrue(Solution.isOneEditAway("Флаг","флаг"));
        Assert.assertTrue(Solution.isOneEditAway("флаг","Флаг"));

        Assert.assertTrue(Solution.isOneEditAway("01","91"));
        Assert.assertTrue(Solution.isOneEditAway("01","091"));
        Assert.assertTrue(Solution.isOneEditAway("01","1"));
        Assert.assertTrue(Solution.isOneEditAway("091","91"));
        Assert.assertTrue(Solution.isOneEditAway("123", "1023"));

//false
        Assert.assertFalse(Solution.isOneEditAway("Флаг","Фиг"));
        Assert.assertFalse(Solution.isOneEditAway("Фиг","Флаг"));

        Assert.assertFalse(Solution.isOneEditAway("Флаг","Фиговый"));
        Assert.assertFalse(Solution.isOneEditAway("Фиговый","Флаг"));

        Assert.assertFalse(Solution.isOneEditAway("makka", "mak"));

        Assert.assertFalse(Solution.isOneEditAway("01", "102"));
        Assert.assertFalse(Solution.isOneEditAway("2", "44"));
        Assert.assertFalse(Solution.isOneEditAway("1234", "12367"));



    }
    @Test
    public static boolean isOneEditAway(String first, String second) {


        if (first.isEmpty() || second.isEmpty()) {
            return true;
        }
        if(first.equals(second)){
            return true;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        if(second.length() > first.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if(i!=first.length()-1) {
                        first = first.substring(0, i) + second.charAt(i) + first.substring(i);
                        if(first.equals(second)){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        first= first.substring(0,i)+second.charAt(i)+first.charAt(i);
                        if(first.equals(second)){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
            first = first+second.charAt(second.length()-1);
            if(first.equals(second)){
                return true;
            }else{
                return false;
            }
        }

        if(second.length() < first.length()) {
            for (int i = 0; i < second.length(); i++) {
                if (second.charAt(i) != first.charAt(i)) {
                    if(i!=first.length()-1) {
                        second = second.substring(0, i) + first.charAt(i) + second.substring(i);
                        if(second.equals(first)){
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        second= second.substring(0,i)+first.charAt(i)+second.charAt(i);
                        if(first.equals(second)){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
            second = second+first.charAt(first.length()-1);
            if(first.equals(second)){
                return true;
            }else{
                return false;
            }
        }

        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) != first.charAt(i)) {
                if(i!=first.length()-1) {
                    second = second.substring(0, i) + first.charAt(i) + second.substring(i + 1);
                    if (second.equals(first)) {
                        return true;
                    } else {
                        return false;
                    }
                }else{
                    second = second.substring(0, i)+first.charAt(i);
                    if (second.equals(first)) {
                        return true;
                    } else {
                        return false;
                    }
                }

                }
            }


        return false;
    }

}
