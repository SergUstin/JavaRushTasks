package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = console.readLine();
            fileName2 = console.readLine();
        }

        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            for (String string : list) {
                String[] split = string.trim().split(" ");
                for (String word : split) {
                    try {
                        int num = Integer.parseInt(word);
                        writer.write(word + " ");
                    } catch (Exception ignore) {

                    }
                }

            }
        }


    }
}
