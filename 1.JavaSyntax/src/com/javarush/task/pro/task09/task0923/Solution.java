package com.javarush.task.pro.task09.task0923;

/* 
Ранг доступа — Пиратский Капитан
*/

import static com.javarush.task.pro.task09.task0923.CaptainBridge.checkAccess;

public class Solution {
    public static void main(String[] args) {
        String[] ranks = {"Раб", "Гость", "Боец", "Ветеран", "Картографист", "Капитан", "Стив"};
        String name = "";
        for (int i = 0; i < ranks.length; i++) {
            CaptainBridge.debugAccess(ranks[i]);
            if (CaptainBridge.debugAccess(ranks[i])) {
                name = ranks[i];
            }
        }

        checkAccess(name);

    }
}
