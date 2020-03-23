package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    public StringForFirstThreadTooShortException(String coz){
        initCause(new IndexOutOfBoundsException(coz));
    }
}
