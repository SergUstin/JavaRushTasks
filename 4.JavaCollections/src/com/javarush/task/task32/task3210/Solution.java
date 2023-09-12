package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw")) {
            accessFile.seek(number);
            byte[] readBytes = new byte[text.length()];
            accessFile.read(readBytes, 0, text.length());

            String readString = new String(readBytes);

            accessFile.seek(accessFile.length());
            if (readString.equals(text)) {
                accessFile.write("true".getBytes());
            } else {
                accessFile.write("false".getBytes());
            }

        } catch (Exception ignore) {

        }


    }
}
