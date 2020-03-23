package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream ps = System.out;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileOutputStream bw = new  FileOutputStream(fileName);

        ByteArrayOutputStream bs = new ByteArrayOutputStream();

        PrintStream ps2 = new PrintStream(bs);
        System.setOut(ps2);

        testString.printSomething();
        String result = bs.toString();
        for(int i = 0 ; i < result.length(); i ++) {
            bw.write(result.charAt(i));
        }
        bw.close();
        System.setOut(ps);
        System.out.print(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

