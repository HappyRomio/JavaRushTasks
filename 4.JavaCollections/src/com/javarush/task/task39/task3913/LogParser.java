package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery , UserQuery , DateQuery , EventQuery, QLQuery {
    private Path logDir;
    public LogParser(Path logDir){
        this.logDir = logDir;

    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

       for(String record : log){
           Helper.addElement(result,record,record.split("\\t")[0],after,before);
       }
        return result.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

        for(String record : log){
            Helper.addElement(result,record,record.split("\\t")[0],after,before);
        }
        return result;

    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

        for(String record : log){
                String[] userName = record.split("\\t");
                    if (userName[1].equals(user)) {
                        Helper.addElement(result,record,record.split("\\t")[0],after,before);
                    }
            }
        return result;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) throws ParseException {

        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

        for(String record : log){
                String [] eventFromRecord = record.split("\\t");
                if(eventFromRecord[eventFromRecord.length-2].split(" ")[0].equals(event.name())) {
                    Helper.addElement(result,record,record.split("\\t")[0],after,before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

        for(String record : log){
                String [] statusFromRecord = record.split("\\t");
                if(statusFromRecord[statusFromRecord.length-1].equals(status.name())) {
                    Helper.addElement(result,record,record.split("\\t")[0],after,before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getAllUsers() {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
            result.add(record.split("\\t")[1]);
        }
        return result;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
            String [] statusFromRecord = record.split("\\t");
            Helper.addElement(result,record,statusFromRecord[1],after,before);
            }
        return result.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

        Pattern  dates= Pattern.compile("[0-9]+\\.[0-9]+\\.[0-9]+ [0-9]+:[0-9]+:[0-9]+");
        Matcher matcher;
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[1].equals(user)) {
                    Helper.addElement(result,record,splitedRecord[splitedRecord.length-2].split(" ")[0],after,before);
                }
            }
        return result.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();

        for(String record : log) {
            String[] splitedRecord = record.split("\\t");
            if (splitedRecord[0].equals(ip)) {
                Helper.addElement(result, record, splitedRecord[1], after, before);
            }
        }

        return result;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].equals(Event.LOGIN.name())) {
                    Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].equals(Event.DOWNLOAD_PLUGIN.name())) {
                    Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].equals(Event.WRITE_MESSAGE.name())) {
                    Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].split(" ")[0].equals(Event.SOLVE_TASK.name())) {
                    Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].split(" ")[0].equals(Event.SOLVE_TASK.name()) && splitedRecord[splitedRecord.length-2].split(" ")[1].equals(String.valueOf(task))) {
                    Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].split(" ")[0].equals(Event.DONE_TASK.name())) {
                    Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<String> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].split(" ")[0].equals(Event.DONE_TASK.name()) && splitedRecord[splitedRecord.length-2].split(" ")[1].equals(String.valueOf(task))) {
                Helper.addElement(result, record, splitedRecord[1], after, before);
                }
            }
        return result;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[1].equals(user) && splitedRecord[splitedRecord.length-2].split(" ")[0].equals(event.name())) {
                    Helper.addCurDate(result, record, after, before);
                }
            }
        return result;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();

        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-1].equals(Status.FAILED.name())) {
                    Helper.addCurDate(result, record, after, before);
                }
        }
        return result;
    }

@Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-1].equals(Status.ERROR.name())) {
                    Helper.addCurDate(result, record, after, before);
                }
            }
        return result;
    }


    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();
        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[splitedRecord.length-2].equals(Event.LOGIN.name()) && splitedRecord[1].equals(user)) {
                    Helper.addCurDate(result, record, after, before);
                }
            }
        try {
            return Collections.min(result);
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();

        for(String record : log){
            String[] splitedRecord = record.split("\\t");
            if (splitedRecord[1].equals(user)&&splitedRecord[splitedRecord.length-2].split(" ")[0].equals(Event.SOLVE_TASK.name()) && splitedRecord[splitedRecord.length-2].split(" ")[1].equals(String.valueOf(task)) ) {
                Helper.addCurDate(result, record, after, before);
            }
        }

        try {
            return Collections.min(result);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();

        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[1].equals(user)&&splitedRecord[splitedRecord.length-2].split(" ")[0].equals(Event.DONE_TASK.name()) && splitedRecord[splitedRecord.length-2].split(" ")[1].equals(String.valueOf(task)) ) {
                    Helper.addCurDate(result, record, after, before);
                }
            }

        try {
            return Collections.min(result);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();

        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[1].equals(user)&& splitedRecord[splitedRecord.length-2].equals(Event.WRITE_MESSAGE.name())) {
                    Helper.addCurDate(result, record, after, before);
                    }
                }
       return result;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Date> result = new HashSet<>();

        for(String record : log){
                String[] splitedRecord = record.split("\\t");
                if (splitedRecord[1].equals(user)&&splitedRecord[splitedRecord.length-2].equals(Event.DOWNLOAD_PLUGIN.name())) {
                    Helper.addCurDate(result, record, after, before);
                }
        }

        return result;
    }


    @Override
    public int getNumberOfAllEvents(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Event> result = new HashSet<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                Helper.addElement(result,help.event, record, after, before);
            }
        }

        return result.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Event> result = new HashSet<>();
        for(String record : log){
            {
               Helper help = new Helper<>(record);
                Helper.addElement(result,help.event, record, after, before);
            }
        }

        return result;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Event> result = new HashSet<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.ip.equals(ip)) {
                    Helper.addElement(result, help.event, record, after, before);
                }
            }
        }

        return result;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Event> result = new HashSet<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.name.equals(user)) {
                    Helper.addElement(result, help.event, record, after, before);
                }
            }
        }

        return result;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Event> result = new HashSet<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.status == Status.FAILED) {
                    Helper.addElement(result, help.event, record, after, before);
                }
            }
        }

        return result;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        Set<Event> result = new HashSet<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.status == Status.ERROR) {
                    Helper.addElement(result, help.event, record, after, before);
                }
            }
        }

        return result;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        List<Event> result = new ArrayList<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.event == Event.SOLVE_TASK && help.task == task) {
                    Helper.addElement(result, help.event, record, after, before);
                }
            }
        }

        return result.size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        List<Event> result = new ArrayList<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.event == Event.DONE_TASK && help.task == task) {
                    Helper.addElement(result, help.event, record, after, before);
                }
            }
        }

        return result.size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        List<Integer> result = new ArrayList<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.event == Event.SOLVE_TASK) {
                    Helper.addElement(result, help.task, record, after, before);
                }
            }
        }

        Map <Integer, Integer> map = new HashMap<>();
        for(Integer tas : result) {
            map.merge(tas, 1, (oldVal, newVal) -> oldVal + newVal);
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) throws ParseException {
        List<String> log = Helper.readLogFiles(logDir);
        List<Integer> result = new ArrayList<>();
        for(String record : log){
            {
                Helper help = new Helper<>(record);
                if(help.event == Event.DONE_TASK) {
                    Helper.addElement(result, help.task, record, after, before);
                }
            }
        }

        Map <Integer, Integer> map = new HashMap<>();
        for(Integer tas : result) {
            map.merge(tas, 1, (oldVal, newVal) -> oldVal + newVal);
        }
        return map;
    }


    @Override
    public Set<Object> execute(String query) throws ParseException {
        Date after = new Date();
        Date before = new Date();
        boolean range= false;
        if(query.contains("and date between")){
            String [] prepare = query.split("and date between");
            String [] result = prepare[1].split("and");

            DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            after = format.parse(result[0].trim().replace("\"",""));
            before = format.parse(result[1].trim().replace("\"",""));
            range = true;

        }

        List<String> log = Helper.readLogFiles(logDir);
        Set<Object> result = new HashSet<>();
        String value ="";
        if(query.indexOf("\"")!=-1) {
            value = query.substring(query.indexOf("\"")+1, query.indexOf("\"",query.indexOf("\"")+1) );

        }
        String[] splitedQuery = query.split(" ");
        if(splitedQuery[0].equals("get")){
            switch (splitedQuery[1]) {
                case "ip":
                    if(splitedQuery.length > 2 && splitedQuery[2].equals("for")){
                        switch (splitedQuery[3]){
                            case "user":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);

                                        if(help.name.toLowerCase().equals(value.toLowerCase())) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.ip, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.ip, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "event":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.event.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.ip, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.ip, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "status":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.status.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.ip, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.ip, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "date":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.date.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.ip, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.ip, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                        }
                    }
                    for(String record : log){
                        {
                            Helper help = new Helper<>(record);
                            Helper.addElement(result, (Object)help.ip, record, null, null);
                        }
                    }
                    return result;
                case "user":
                    if(splitedQuery.length > 2 && splitedQuery[2].equals("for")){
                        switch (splitedQuery[3]){
                            case "ip":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.ip.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.name, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.name, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "event":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.event.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.name, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.name, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "status":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.status.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.name, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.name, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "date":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.date.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.name, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.name, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                        }
                    }
                    for(String record : log){
                        {
                            Helper help = new Helper<>(record);
                            Helper.addElement(result, help.name, record, null, null);
                        }
                    }
                    return result;
                case "date":
                    if(splitedQuery.length > 2 && splitedQuery[2].equals("for")){
                        switch (splitedQuery[3]){
                            case "ip":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                        Date time = format.parse(help.date);
                                        if(help.ip.equals(value)) {
                                            if(range){
                                                if(time.after(after)&&time.before(before)){
                                                    Helper.addElement(result, (Object) time, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) time, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "event":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                        Date time = format.parse(help.date);
                                        if(help.event.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                if(time.after(after)&&time.before(before)){
                                                    Helper.addElement(result, (Object) time, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) time, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "status":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                        Date time = format.parse(help.date);
                                        if(help.status.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                if(time.after(after)&&time.before(before)){
                                                    Helper.addElement(result, (Object) time, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) time, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "user":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                        Date time = format.parse(help.date);
                                        if(help.name.equals(value)) {
                                            if(range){
                                                if(time.after(after)&&time.before(before)){
                                                    Helper.addElement(result, (Object) time, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) time, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                        }
                    }
                    for(String record : log){
                        {
                            Helper help = new Helper<>(record);
                            DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                            Date time = format.parse(help.date);
                            Helper.addElement(result, time, record, null, null);
                        }
                    }
                    return result;
                case "event":
                    if(splitedQuery.length > 2 && splitedQuery[2].equals("for")){
                        switch (splitedQuery[3]){
                            case "ip":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.ip.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.event, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.event, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "user":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.name.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.event, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.event, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "status":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.status.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.event, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.event, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "date":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.date.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.event, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.event, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                        }
                    }
                    for(String record : log){
                        {
                            Helper help = new Helper<>(record);
                            Helper.addElement(result, help.event, record, null, null);
                        }
                    }
                    return result;
                case "status":
                    if(splitedQuery.length > 2 && splitedQuery[2].equals("for")){
                        switch (splitedQuery[3]){
                            case "ip":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.ip.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.status, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.status, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "event":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.event.name().equals(splitedQuery[5].replace("\"",""))) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.status, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.status, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "user":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.name.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.status, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.status, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                            case "date":
                                for(String record : log){
                                    {
                                        Helper help = new Helper<>(record);
                                        if(help.date.equals(value)) {
                                            if(range){
                                                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                                Date d = format.parse(help.date);
                                                if(d.after(after)&&d.before(before)){
                                                    Helper.addElement(result, (Object) help.status, record, null, null);
                                                }
                                            }else {
                                                Helper.addElement(result, (Object) help.status, record, null, null);
                                            }
                                        }
                                    }
                                }
                                return result;
                        }
                    }
                    for(String record : log){
                        {
                            Helper help = new Helper<>(record);
                            Helper.addElement(result, help.status, record, null, null);
                        }
                    }
                    return result;
            }
        }else {
            System.out.println("Wrong command");
        }


        return null;
    }
}