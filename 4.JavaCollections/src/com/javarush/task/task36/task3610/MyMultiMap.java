package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int count = 0;

        for(Map.Entry entry : map.entrySet()){
            for(V value : (List<V>)entry.getValue()){
                count++;
            }
        }


        return count;
    }

    @Override
    public V put(K key, V value) {

        V valueForReturn = null;
        List<V> listOfValues =  map.get(key);
        if(listOfValues!=null){
            if(listOfValues.size() == repeatCount){
                valueForReturn = listOfValues.get(repeatCount-1);
                listOfValues.remove(0);
                listOfValues.add(value);
                return valueForReturn;
            }else {
                valueForReturn = listOfValues.get(listOfValues.size()-1);
                listOfValues.add(value);
                return valueForReturn;
            }
        } else {
            listOfValues = new ArrayList<V>();
            listOfValues.add(value);
            map.put(key,listOfValues);
            return valueForReturn;
        }
    }

    @Override
    public V remove(Object key) {
        V valueForReturn = null;
        List<V> listOfValues =  map.get(key);
        if(listOfValues==null){
            return valueForReturn;
        }else{
            valueForReturn = listOfValues.get(0);
            listOfValues.remove(0);
            if(listOfValues.size()==0){
                map.remove(key);
                return valueForReturn;
            }else{
                return valueForReturn;
            }
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> allValues = new ArrayList<>();
        for(Entry<K, List<V>> entry : map.entrySet() ){
            for(V value : entry.getValue()){
                allValues.add(value);
            }
        }
        return allValues;
    }

    @Override
    public boolean containsKey(Object key) {
       return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for(V v : values()){
            if(v.equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}