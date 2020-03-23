package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K,V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V obj = cache.get(key);
        if(obj == null){
            V newValue = (V) clazz.getDeclaredConstructor(key.getClass()).newInstance(key);
            cache.put(key, newValue);
            return newValue;

        }
        return obj;
    }

    public boolean put(V obj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        try{
        Method getKey = obj.getClass().getDeclaredMethod("getKey",null);
            getKey.setAccessible(true);
            K key = (K) getKey.invoke(obj,null);

            cache.put(key,obj);
                }catch(Exception e){
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
