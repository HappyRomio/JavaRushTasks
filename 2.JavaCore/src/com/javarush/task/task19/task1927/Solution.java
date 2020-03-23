package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stdOut = System.out;

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bs);
        System.setOut(new PrintStream(ps) {
            private int count = 0;
            @Override
            public void println(String s) {
                this.print(s);
                this.print('\n');
                count++;
                if(count==2){
                    this.print("JavaRush - курсы Java онлайн");
                    this.print('\n');
                    count =0;
                }
            }
        });
        testString.printSomething();
        System.setOut(stdOut);
        System.out.println(bs.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
