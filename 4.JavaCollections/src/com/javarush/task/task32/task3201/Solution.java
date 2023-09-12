package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw")) {
            number = Math.min(number, accessFile.length());
            accessFile.seek(number);
            accessFile.write(text.getBytes());
        } catch (IOException ignore) {

        }


    }
}
