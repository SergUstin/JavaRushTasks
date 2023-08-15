package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            Set<Wheel> wheelSet = new HashSet<>(4);
            String[] wheelNamesFromDb = loadWheelNamesFromDB();
            if (wheelNamesFromDb.length != 4) throw new IllegalArgumentException();
            for (String wheelName : wheelNamesFromDb) {
                wheelSet.add(Wheel.valueOf(wheelName));
            }
            if (wheelSet.size() != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>(wheelSet);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
