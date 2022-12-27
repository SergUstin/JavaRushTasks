package com.javarush.task.pro.task05.task0525;

/* 
Ловушка для Роботанка
*/

public class Solution {
    public static String[] array = {"Amigo", "Diego","Amigo", "Diego","Amigo", "Diego", "robotank"};

    public static void main(String[] args) {
        /*
        array = new String[6];
        array[0] = "Amigo";
        array[1] = "Diego";
        array[2] = "Amigo";
        array[3] = "Diego";
        array[4] = "Amigo";
        array[5] = "Diego";
         */

        boolean isMissionComplete = false;
        for (int i = 0; i < array.length; i++) {
            if ("robotank".equalsIgnoreCase(array[i])) {
                isMissionComplete = true;
                break;
            }
        }
        System.out.println(isMissionComplete ? "Mission complete" : "Mission not completed");
    }
}