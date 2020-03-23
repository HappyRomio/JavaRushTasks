package com.javarush.task.task35.task3502;

import java.util.List;

/*
Знакомство с дженериками
*/
public class Solution <Ts extends List<Solution.SomeClass>> {
    public static class SomeClass< Tc extends Number> {
    }

    public static void main(String[] args) {

    }
}
