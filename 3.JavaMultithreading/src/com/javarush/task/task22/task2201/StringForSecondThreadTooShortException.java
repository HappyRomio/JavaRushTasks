package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(String coz){
        initCause(new IndexOutOfBoundsException(coz));
    }
}
