package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;


    int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }
    int indexFor(int hash, int length){
        return hash & (length-1);
    }
    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }
    void resize(int newCapacity){
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1<<30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }
    void transfer(Entry[] newTable){
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    void addEntry(int hash, Long key, String value, int bucketIndex){
    Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
        resize(2 * table.length);
        }
    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        Entry e = getEntry(key);
        return e==null? false: true;
    }

    @Override
    public boolean containsValue(String value) {
        for(int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                Entry entry = table[i];
                do {
                    if (entry.getValue().equals(value)) {
                        return true;
                    } else {
                        entry = entry.next;
                    }
                } while (entry != null);
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash((long)key.hashCode());
        int i = indexFor(hash, table.length);
        addEntry(hash,key,value,i);

    }

    @Override
    public Long getKey(String value) {

        for(int i = 0 ; i < table.length;i++) {
            if (table[i] != null) {
                Entry e = table[i];
                do {
                    if (e.getValue().equals(value)) {
                        return e.key;
                    } else {
                        e = e.next;
                    }

                } while (e!=null);
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry e = getEntry(key);

        return e!=null ? e.value : null;
    }
}
