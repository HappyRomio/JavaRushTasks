package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date workTimeStart = new Date();

        for(String s : strings){
            ids.add(shortener.getId(s));
        }
        Date workTimeEnd = new Date();
        Long workTime = workTimeEnd.getTime() - workTimeStart.getTime();
        return workTime;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date workTimeStart = new Date();

        for(Long i : ids){
           strings.add(shortener.getString(i));
        }
        Date workTimeEnd = new Date();
        Long workTime = workTimeEnd.getTime() - workTimeStart.getTime();
        return workTime;
    }
    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();

        for(int i = 0 ; i < 10000;i ++){
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids = new HashSet<>();

        long a = getTimeToGetIds(shortener1,origStrings,ids);
        long b = getTimeToGetIds(shortener2,origStrings,ids);

        Assert.assertTrue(a > b);
        a = getTimeToGetStrings(shortener1,ids,origStrings);
        b = getTimeToGetStrings(shortener2,ids,origStrings);
        Assert.assertEquals(a, b, 30);

    }
}
