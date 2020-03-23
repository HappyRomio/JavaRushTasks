package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
            if(!getVersionHistoryMap().containsKey(rollbackVersion)) {
                return false;
            }
            List<Integer> integers = new ArrayList<>();
            for(Map.Entry<Integer,String> entry : versionHistoryMap.entrySet() ){
                if(entry.getKey()> rollbackVersion){
                    integers.add(entry.getKey());
                }
            }
            for (Integer integer : integers){
                versionHistoryMap.remove(integer);
            }
            currentVersion = rollbackVersion;

        return true;
    }
}
