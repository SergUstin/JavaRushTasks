package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        List<Integer> list = new ArrayList<>();

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(console.readLine())))) {
            while (reader.ready()) {
                int number = Integer.parseInt(reader.readLine());
                if (number % 2 == 0) {
                    list.add(number);
                }
            }
            list.stream().sorted().forEach(System.out::println);
        }

    }
}
