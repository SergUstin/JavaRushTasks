package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> byteCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream file = new FileInputStream(reader.readLine())) {
            while (file.available() > 0) {
                byteCount.put(file.read(), file.available());
            }
        }

        Set<Integer> sortedSet = new TreeSet<>(byteCount.keySet());
        for (Integer integer : sortedSet) {
            System.out.print(integer + " ");
        }
    }
}