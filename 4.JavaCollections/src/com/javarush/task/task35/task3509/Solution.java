package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static<T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arr = new ArrayList<>();
        for(Object o : elements){
            arr.add((T)o);
        }
        return arr;
    }

    public static<T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();
        for(Object o : elements){
            set.add((T)o);
        }
        return set;
    }

    public static<K,V> HashMap<K,V> newHashMap(List <? extends K> keys, List<? extends V> values) {
        HashMap<K,V> map = new HashMap<>();
        if(keys.size()==values.size()){
            for(int i = 0 ; i < keys.size(); i++){
                map.put((K)keys.get(i),(V)values.get(i));
            }
        } else {
            throw new IllegalArgumentException ();
        }
        return map;
    }
}
