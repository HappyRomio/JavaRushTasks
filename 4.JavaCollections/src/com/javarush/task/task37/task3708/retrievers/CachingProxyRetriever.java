package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    LRUCache cache = new LRUCache(10);
    OriginalRetriever orig;

   public CachingProxyRetriever(Storage storage){
        orig = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = cache.find(id);
        if(obj==null){
           Object o =  orig.retrieve(id);
            cache.set(id,o);
            return o;
        }
        return obj;
    }
}
