package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputFile = reader.readLine();
        String inputFile = reader.readLine();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream = new FileInputStream(outputFile);
             FileInputStream fileInputStream1 = new FileInputStream(inputFile)) {
            while (fileInputStream1.available() > 0) {
                byteArrayOutputStream.write(fileInputStream1.read());
            }
            while (fileInputStream.available() > 0) {
                byteArrayOutputStream.write(fileInputStream.read());
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }

    }
}
