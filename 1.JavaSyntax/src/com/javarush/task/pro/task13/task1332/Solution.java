package com.javarush.task.pro.task13.task1332;

/* 
Вирусы в Инстаматрице
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static Set<String> matrixLogs = new HashSet<>();

    public static void main(String[] args) {
        fillMatrixLog();
        removeBugs();

        for (String logs : matrixLogs) {
            System.out.println(logs);
        }
    }
    public static void removeBugs () {
        ArrayList<String> copyList = new ArrayList<>(matrixLogs);
        for (String str : copyList) {
            if (str.startsWith("buahaha")) {
                matrixLogs.remove(str);
            }
        }
    }

    public static void fillMatrixLog() {
        for (int i = 0; i < 400; i++) {
            matrixLogs.add("interestingLog" + i + ".log");
            if ((i > 0) && (i % 5 == 0) && (i < 295)) {
                matrixLogs.add("buahaha" + i + ".bug");
            }
        }
    }
}