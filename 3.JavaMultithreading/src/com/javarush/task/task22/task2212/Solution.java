package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        return telNumber == null ? false : telNumber.matches("(?=.{10,16})^[\\+\\d](?!(?:.*-){4})(?!.*--)(?=[^()]*\\([^()]+\\)[^()]*$|[^()]*$)\\d+[(\\-)\\d]+\\d");
    }

    public static void main(String[] args) {
        System.out.print(checkTelNumber("+380501234567"));
        System.out.print(checkTelNumber("+38(050)1234567"));
        System.out.print(checkTelNumber("+38050123-45-67"));
        System.out.print(checkTelNumber("050123-4567"));
        System.out.print(checkTelNumber("+38)050(1234567"));
        System.out.print(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.print(checkTelNumber("050ххх4567"));
        System.out.print(checkTelNumber("050123456"));
        System.out.print(checkTelNumber("(0)501234567"));
    }
}
