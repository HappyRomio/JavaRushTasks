package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
            Object o = 1L;
            Integer i = (Integer)o;
    }

    public void methodThrowsNullPointerException() {
            String s = null;
            s.length();
    }

    public static void main(String[] args) {

    }
}
