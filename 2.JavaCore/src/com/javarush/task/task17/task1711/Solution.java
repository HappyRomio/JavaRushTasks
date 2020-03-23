package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();



    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i <= args.length - 1;i+=3 ) {
                            if (args[i + 1].equals("м")) {
                                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                                allPeople.add(Person.createMale(args[i], form.parse(args[i + 2])));
                                System.out.println(allPeople.size() - 1);
                            } else {
                                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                                allPeople.add(Person.createFemale(args[i], form.parse(args[i + 2])));
                                System.out.println(allPeople.size() - 1);
                            }
                        }
                    }
                break;
                case "-u" :
                    synchronized (allPeople) {
                        for (int i = 1; i <= args.length - 1; i+=4) {
                            Person forUpadte = allPeople.get(Integer.parseInt(args[i]));

                            forUpadte.setName(args[i + 1]);
                            forUpadte.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);

                            SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            forUpadte.setBirthDate(form.parse(args[i + 3]));
                        }
                    }
                break;
                case "-d" :
                    synchronized (allPeople) {
                        for (int i = 1; i <= args.length - 1; i++) {
                            Person forDel = allPeople.get(Integer.parseInt(args[i]));
                            forDel.setName(null);
                            forDel.setSex(null);
                            forDel.setBirthDate(null);
                        }
                    }
                break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i <= args.length - 1; i++) {
                            Person forPrint = allPeople.get(Integer.parseInt(args[i]));
                            SimpleDateFormat form = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(forPrint.getName() + " " + (forPrint.getSex() == Sex.MALE ? "м" : "ж") + " " + form.format(forPrint.getBirthDate()));
                        }
                    }
                break;
            }
    }
}
