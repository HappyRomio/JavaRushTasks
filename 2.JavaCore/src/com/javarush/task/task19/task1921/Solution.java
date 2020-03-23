package com.javarush.task.task19.task1921;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);

        StringBuilder sb = new StringBuilder();
        int rByte;


        while (fr.ready()) {

            if((char)(rByte=fr.read())!='\n'){
                sb.append((char)rByte);
            } else {

                String[] date = sb.toString().replaceAll("[\\D&&[^ ]]","").trim().split(" ");
                Calendar c = new GregorianCalendar(Integer.parseInt(date[2]),Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
                PEOPLE.add(new Person(sb.toString().replaceAll("[\\d&&[^ ]]","").trim(),c.getTime() ));
                sb.setLength(0);
            }
        }
        String[] date = sb.toString().replaceAll("[\\D&&[^ ]]","").trim().split(" ");
        Calendar c = new GregorianCalendar(Integer.parseInt(date[2]),Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
        PEOPLE.add(new Person(sb.toString().replaceAll("[\\d&&[^ ]]","").trim(),c.getTime() ));

        PEOPLE.forEach(a -> System.out.println(a.getBirthDate() + " " + a.getName()));
        fr.close();
    }
}
