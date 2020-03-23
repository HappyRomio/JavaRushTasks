package com.javarush.task.task39.task3913;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper<E> {

    String ip;
    String name;
    String date;
    Event event;
    int task;
    Status status;

    public Helper(String s){
        String [] helper = s.split("\\t");
        ip = helper[0];
        name = helper[1];
        date = helper[2];
        if(helper[3].split(" ")[0].equals(Event.DOWNLOAD_PLUGIN.name())){
            event = Event.DOWNLOAD_PLUGIN;
        }
        if(helper[3].split(" ")[0].equals(Event.WRITE_MESSAGE.name())){
            event = Event.WRITE_MESSAGE;
        }
        if(helper[3].split(" ")[0].equals(Event.LOGIN.name())){
            event = Event.LOGIN;
        }
        if(helper[3].split(" ")[0].equals(Event.SOLVE_TASK.name())){
            event = Event.SOLVE_TASK;
            task = Integer.parseInt(helper[3].split(" ")[1]);
        }
        if(helper[3].split(" ")[0].equals(Event.DONE_TASK.name())){
            event = Event.DONE_TASK;
            task = Integer.parseInt(helper[3].split(" ")[1]);
        }

        if(helper[4].equals(Status.ERROR.name())){
            status = Status.ERROR;
        }
        if(helper[4].equals(Status.FAILED.name())){
            status = Status.FAILED;
        }
        if(helper[4].equals(Status.OK.name())){
            status = Status.OK;
        }

    }



    public static List<String> readLogFiles(Path path) {
        List<String> log = new ArrayList<>();
        for(File file : path.toFile().listFiles() ) {
            if(file.getName().endsWith(".log")){
                try(BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    while(br.ready()){
                        log.add(br.readLine());
                    }
                } catch (IOException e){

                }
            }
        }

        return log;
    }
    public static void addCurDate(Set<Date> set, String record, Date after, Date before) throws ParseException {

            DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date time = format.parse(record.split("\\t")[2]);

            if (after == null && before == null) {
                set.add(time);
            } else if (after != null && before == null) {
                if (time.after(after)) {
                    set.add(time);
                }
            } else if (after == null && before != null) {
                if ((before.getTime()-time.getTime()) > -100) {
                    set.add(time);
                }
            } else if (after != null && before != null) {
                if (time.after(after) && time.before(before)) {
                    set.add(time);
                }

        }
    }


    public static<E> void addElement (Set<E> set, E elem, String record, Date after, Date before) throws ParseException {


        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date time = format.parse(record.split("\\t")[2]);
        if (after == null && before == null) {
            set.add(elem);
        } else if (after != null && before == null) {
            if (time.after(after)) {
                set.add(elem);
            }
        } else if (after == null && before != null) {
            if (time.before(before)) {
                set.add(elem);
            }
        } else if (after != null && before != null) {
            if (time.after(after) && time.before(before)) {
                set.add(elem);
            }
        }
    }




    public static<E> void addElement (List<E> set, E elem, String record, Date after, Date before) throws ParseException {


        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date time = format.parse(record.split("\\t")[2]);
        if (after == null && before == null) {
            set.add(elem);
        } else if (after != null && before == null) {
            if (time.after(after)) {
                set.add(elem);
            }
        } else if (after == null && before != null) {
            if (time.before(before)) {
                set.add(elem);
            }
        } else if (after != null && before != null) {
            if (time.after(after) && time.before(before)) {
                set.add(elem);
            }
        }
    }
}
