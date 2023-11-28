package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

public class HashBiMapStorageStrategy implements StorageStrategy {
    private HashBiMap<Long, String> data = HashBiMap.create();

    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    public void put(Long key, String value) {
        data.put(key, value);
    }

    public String getValue(Long key) {
        return data.get(key);
    }

    public Long getKey(String value) {
        return data.inverse().get(value);
    }
}
