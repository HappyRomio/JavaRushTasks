package com.javarush.task.task35.task3512;

import java.lang.reflect.InvocationTargetException;

public class Generator<T> {
        Class<T> clas;

    public Generator(Class<T> eventClass) {
        clas = eventClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return clas.getDeclaredConstructor().newInstance();
    }
}
