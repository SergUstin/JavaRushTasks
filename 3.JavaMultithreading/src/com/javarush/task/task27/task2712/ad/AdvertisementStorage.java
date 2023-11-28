package com.javarush.task.task27.task2712.ad;

import java.util.LinkedList;
import java.util.List;

public class AdvertisementStorage {
    private static class InstanceHolder {
        private static final AdvertisementStorage ourInstance = new AdvertisementStorage();
    }

    public static AdvertisementStorage getInstance() {
        return InstanceHolder.ourInstance;
    }

    private final List<Advertisement> videos = new LinkedList<>();

    private AdvertisementStorage() {
        //init random videos
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));   //weight=277
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));   //weight=11
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));     //weight=333
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
