package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        if (softReference == null) {
            return null;
        }

        return softReference.get();
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));

        if (softReference == null) {
            return null;
        }

        AnyObject oldValue = softReference.get();
        softReference.clear();
        return oldValue;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        if (softReference == null) {
            return null;
        }

        AnyObject oldValue = softReference.get();
        softReference.clear();

        return oldValue;
    }
}