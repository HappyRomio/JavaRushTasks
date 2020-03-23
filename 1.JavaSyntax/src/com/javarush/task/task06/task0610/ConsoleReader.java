package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/



public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return r.readLine();
    }

    public static int readInt() throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(r.readLine());

    }

    public static double readDouble() throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(r.readLine());

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        return r.readLine().equals("true") ? true : false;

    }

    public static void main(String[] args) throws Exception {

    }
}
