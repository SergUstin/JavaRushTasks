package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }

        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int count = 4;

        System.out.println("Введите номер телефона");
        while (count > 0) {
            String telNumber = console.readLine();
            if (checkTelNumber(telNumber)) {
                System.out.println(telNumber + " - " + checkTelNumber(telNumber));
            } else {
                System.out.println(telNumber + " - " + checkTelNumber(telNumber));
            }
            count--;
        }
    }
}
