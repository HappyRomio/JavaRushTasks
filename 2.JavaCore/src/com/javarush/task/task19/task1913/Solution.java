package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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
        String result = bs.toString().replaceAll("\\D","");
        System.setOut(ps);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
