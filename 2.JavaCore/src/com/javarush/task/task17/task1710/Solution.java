package com.javarush.task.task17.task1710;

import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        if(args[0].equals("-c")){
            if(args[2].equals("м")) {
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                allPeople.add(Person.createMale(args[1], form.parse(args[3])));
                System.out.println(allPeople.size()-1);
            } else {
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                allPeople.add(Person.createFemale(args[1], form.parse(args[3])));
                System.out.println(allPeople.size()-1);
            }
        } else if  (args[0].equals("-u")){

            Person forUpadte = allPeople.get(Integer.parseInt(args[1]));

            forUpadte.setName(args[2]);
            forUpadte.setSex(args[3].equals("м")?Sex.MALE:Sex.FEMALE);

            SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            forUpadte.setBirthDate(form.parse(args[4]));

        }else if  (args[0].equals("-d")) {
            Person forDel = allPeople.get(Integer.parseInt(args[1]));
            forDel.setName(null);
            forDel.setSex(null);
            forDel.setBirthDate(null);
        } else if(args[0].equals("-i")) {
            Person forPrint = allPeople.get(Integer.parseInt(args[1]));
            SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(forPrint.getName() + " " + (forPrint.getSex()==Sex.MALE?"м":"ж") + " " + form.format(forPrint.getBirthDate()) );
        }

    }
}
