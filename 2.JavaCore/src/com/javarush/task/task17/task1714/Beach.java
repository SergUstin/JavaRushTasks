package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach = new Beach("Beach1", 200, 10);
        Beach beach1 = new Beach("Beach2", 300, 5);
        System.out.println(beach.compareTo(beach1));


    }

    @Override
    public int compareTo(Beach o) {
        if (o.getDistance() < o.getDistance() && o.getQuality() > o.getQuality()) {
            return 1;
        }
        return 0;
    }
}
