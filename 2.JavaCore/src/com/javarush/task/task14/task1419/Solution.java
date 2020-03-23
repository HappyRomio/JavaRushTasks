package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            initExceptions2();
        }

        //напишите тут ваш код

    }
    private static void initExceptions2() {
        try {
            int [] i = new int[1];
            System.out.print(i[10]);

        } catch (Exception e) {
            exceptions.add(e);
            initExceptions3();
        }
        }

    private static void initExceptions3() {
        try {
          Object t = new Integer("2");
          Solution d = (Solution)t;


        } catch (Exception e) {
            exceptions.add(e);
            initExceptions4();
        }
    }

    private static void initExceptions4() {
        try {
            int [] i = new int[-1];



        } catch (Exception e) {
            exceptions.add(e);
            initExceptions5();
        }
    }

    private static void initExceptions5() {
        try {
            ArrayList t = new ArrayList();

            t.get(12);



        } catch (Exception e) {
            exceptions.add(e);
            initExceptions6();
        }
    }



    private static void initExceptions6() {
        try {
            Integer.parseInt("dsds");



        } catch (Exception e) {
            exceptions.add(e);
            initExceptions7();
        }
    }

    private static void initExceptions7() {
        try {
    Integer i = null;
    i.hashCode();

        } catch (Exception e) {
            exceptions.add(e);
            initExceptions8();
        }
    }

    private static void initExceptions8() {
        try {
            "dsadasd".charAt(100);

        } catch (Exception e) {
            exceptions.add(e);
            initExceptions9();
        }
    }


    private static void initExceptions9() {
        try {
            FileInputStream br = new FileInputStream("fdsffsd");
        } catch (Exception e) {
            exceptions.add(e);
            initExceptions10();
        }
    }

    private static void initExceptions10() {
        try {
            Object [] objArr = new Integer[2];
            objArr[0]=1;

            String [] strArr = Arrays.copyOf(objArr, objArr.length, String[].class);
        } catch (Exception e) {
            exceptions.add(e);

        }
    }



}
