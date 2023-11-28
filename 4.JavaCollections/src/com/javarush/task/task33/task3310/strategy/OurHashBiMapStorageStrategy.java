package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> k2v = new HashMap<>();
    private HashMap<String, Long> v2k = new HashMap<>();

    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    public String getValue(Long key) {
        return k2v.get(key);
    }

    public Long getKey(String value) {
        return v2k.get(value);
    }
}
