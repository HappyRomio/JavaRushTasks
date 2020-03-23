package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil<T extends Convertable<T>> {

    public static <K,T extends Convertable> Map <K,T>  convert(List<T> list) {
        Map<K,T>  result = new HashMap<>();
        for(T elem : list) {
            result.put((K) elem.getKey(),elem);
        }

        return result;
    }
}
