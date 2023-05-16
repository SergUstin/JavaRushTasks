package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] strings = url.substring(url.indexOf("?") + 1).split("&");
        for (String string : strings) {
            System.out.print((string.contains("=") ? string.substring(0, string.indexOf("=")) : string) + " ");
        }

        System.out.println();

        for (String string : strings) {
            if (string.contains("obj")) {
                String value = string.substring(string.indexOf("=") + 1);
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
