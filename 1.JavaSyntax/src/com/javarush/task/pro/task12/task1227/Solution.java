package com.javarush.task.pro.task12.task1227;

/* 
   Ох уж эта жуткая корзина
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<Robot> cableContents = new ArrayList<>(Arrays.asList(new Robot("T1000"),
            new Robot("Amigo"), new Robot("B1"), new Robot("Diego"), new Robot("Zed")));
    private static List<Robot> rescuedRobots = new ArrayList<>();

    public static void main(String[] args) {
    rescueRobots();
    emptyGarbageBin();
    printList(rescuedRobots);
    }

    public static void rescueRobots() {
        for (int i = 0; i < cableContents.size(); i++) {
            if (cableContents.get(i).getName().equals("Amigo") ||
                    cableContents.get(i).getName().equals("Diego")) {
                rescuedRobots.add(cableContents.get(i));
                cableContents.remove(i);
                i--;
            }
        }
    }

    private static void emptyGarbageBin() {
        cableContents.removeAll(rescuedRobots);
        System.out.println("Garbage cleared");
    }

    public static void printList(List<Robot> list) {
        for (Robot o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
