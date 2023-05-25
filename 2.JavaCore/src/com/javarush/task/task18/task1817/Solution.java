package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 
Пробелы
*/

public class Solution {
    public static void main1(String[] args) throws IOException {
        int countSpace = 0;
        int count = 0;
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                int read = reader.read();
                count++;
                if (read == ' ') {
                    countSpace++;
                }
            }
        }
        double index = (double) countSpace / count * 100;
        System.out.println(countSpace);
        System.out.println(count);
        System.out.printf("%.2f", index);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader  = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
        }
        long count = IntStream.range(0, builder.length()).filter(i -> Character.isSpaceChar(builder.toString().toCharArray()[i])).count();
        System.out.println(count);
        System.out.println(builder.length());
        System.out.printf("%.2f", (double) count / builder.length() * 100);
    }
}
