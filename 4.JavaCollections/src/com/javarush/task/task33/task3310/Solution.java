package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import com.javarush.task.task33.task3310.tests.FunctionalTest;
import com.javarush.task.task33.task3310.tests.SpeedTest;


import java.util.*;

public class Solution {
    private HashMap<Long, String> data;
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result = new HashSet<>();

        for(String s : strings){
            result.add(shortener.getId(s));
        }

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){

        Set<String> result = new HashSet<>();

        for(Long id : keys){
            result.add(shortener.getString(id));
        }

        return result;

    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Set<String> set = new HashSet<>();
        Helper.printMessage(strategy.getClass().getSimpleName());
        for(int i = 0 ; i < elementsNumber;i ++){
            set.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date workTimeStart = new Date();
        Set<Long> ids= getIds(shortener,set);
        Date workTimeEnd = new Date();
        Long workTime = workTimeEnd.getTime() - workTimeStart.getTime();
        Helper.printMessage(workTime.toString());

        workTimeStart = new Date();
        Set<String> values= getStrings(shortener,ids);
        workTimeEnd = new Date();
        workTime = workTimeEnd.getTime() - workTimeStart.getTime();
        Helper.printMessage(workTime.toString());
        boolean test = true;
        if(set.size()==values.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }



    }
    public static void main(String ... args){

        // testStrategy(new HashMapStorageStrategy(),10000);
        //testStrategy(new OurHashMapStorageStrategy(),10000);
      //  testStrategy(new FileStorageStrategy(),10);
        //testStrategy(new OurHashBiMapStorageStrategy(),10000);
        SpeedTest sp = new SpeedTest();
        sp.testHashMapStorage();


    }
}
