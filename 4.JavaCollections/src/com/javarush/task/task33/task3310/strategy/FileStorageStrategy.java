package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size = 0;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = DEFAULT_BUCKET_SIZE_LIMIT;


    int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }
    int indexFor(int hash, int length){
        return hash & (length-1);
    }
    void resize(int newCapacity){
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;

        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable){
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            FileBucket e = src[j];
            if (e != null) {
                src[j].remove();
                    Entry en= e.getEntry();
                    int i = indexFor(en.hash, newCapacity);
                    newTable[i] = e;
            }
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }




    @Override
    public boolean containsKey(Long key) {
        for(int i=0; i < table.length; i++){
            if(table[i]!=null){
                for(Entry e = table[i].getEntry(); e!=null;e = e.next){
                    if(e.getKey().equals(key)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        for(int i=0; i < table.length; i++){
            if(table[i]!=null){
                for(Entry e = table[i].getEntry(); e!=null;e = e.next){
                    if(e.getValue().equals(value)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {

            int hash = hash((long) key.hashCode());
            int i = indexFor(hash, table.length);

            FileBucket fb = table[i];

            if (fb != null) {
                Entry entry = fb.getEntry();
                Entry next = entry.next;
                while (true) {
                    if (next == null) {
                        next = new Entry(hash, key, value, null);
                        break;
                    }
                    next = next.next;
                }
                fb.putEntry(entry);

                if (fb.getFileSize() > DEFAULT_BUCKET_SIZE_LIMIT) {
                    resize(2 * DEFAULT_INITIAL_CAPACITY);
                }
            } else {
                table[i] = new FileBucket();
                table[i].putEntry(new Entry(hash, key, value, null));
            }



    }

    @Override
    public Long getKey(String value) {
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    for (Entry e = table[i].getEntry(); e != null; e = e.next) {
                        if (e.getValue().equals(value)) {
                            return e.getKey();
                        }
                    }
                }
            }
        return null;
    }

    @Override
    public String getValue(Long key) {
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    for (Entry e = table[i].getEntry(); e != null; e = e.next) {
                        if (e.getKey().equals(key)) {
                            return e.getValue();
                        }
                    }
                }
            }

        return null;
    }
}
