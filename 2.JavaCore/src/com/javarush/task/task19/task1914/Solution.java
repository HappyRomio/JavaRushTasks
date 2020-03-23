package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ps = System.out;

        ByteArrayOutputStream bs = new ByteArrayOutputStream();

        PrintStream ps2 = new PrintStream(bs);
        System.setOut(ps2);

        testString.printSomething();
        String result = bs.toString();
        System.setOut(ps);

        String numbers = "0123456789 ";
       result = result.substring(0,result.indexOf("="));

        for(int i =0; i < result.length()-1;i++){
            if(!numbers.contains(String.valueOf(result.charAt(i)))){
                if(result.charAt(i)=='+'){
                    System.out.print(result + "= " + (
                            Integer.parseInt(result.substring(0,i).trim()) +
                                    Integer.parseInt(result.substring(i+1).trim())
                            ));
                }
                if(result.charAt(i)=='-'){
                    System.out.print(result + "= " + (
                            Integer.parseInt(result.substring(0,i).trim()) -
                                    Integer.parseInt(result.substring(i+1).trim())
                    ));
                }
                if(result.charAt(i)=='*'){
                    System.out.print(result + "= " + (
                            Integer.parseInt(result.substring(0,i).trim()) *
                                    Integer.parseInt(result.substring(i+1).trim())
                    ));
                }
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

