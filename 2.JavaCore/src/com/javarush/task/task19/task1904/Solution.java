package com.javarush.task.task19.task1904;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("D://1.txt"));
        PersonScannerAdapter psa = new PersonScannerAdapter(sc);

        Person p = psa.read();

        System.out.println(p.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        PersonScannerAdapter(Scanner sc) {
            fileScanner = sc;
        }

        @Override
        public Person read() throws IOException {
            String[] person;
                person = fileScanner.nextLine().split(" ");
                        Calendar c = new GregorianCalendar(Integer.parseInt(person[5]),
                                Integer.parseInt(person[4])-1,Integer.parseInt(person[3]));
                        return new Person(person[1],person[2],person[0],c.getTime());

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
