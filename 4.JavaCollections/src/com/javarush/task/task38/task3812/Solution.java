package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Annotation annotation = c.getAnnotation(PrepareMyTest.class);
        if(annotation!=null){
            PrepareMyTest prepareMyTest = (PrepareMyTest) annotation;
            for(String s : prepareMyTest.fullyQualifiedNames()){
                System.out.println(s);
            }
            return true;
        }

        return false;
    }

    public static boolean printValues(Class c) {
        Annotation annotation = c.getAnnotation(PrepareMyTest.class);
        if(annotation!=null){
            PrepareMyTest prepareMyTest = (PrepareMyTest) annotation;
            for(Class cl : prepareMyTest.value()){
                System.out.println(cl.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
