package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outputFile1 = reader.readLine();
        String inputFile1 = reader.readLine();
        String inputFile2 = reader.readLine();

        try (FileInputStream fileInputStream = new FileInputStream(inputFile1);
             FileInputStream fileInputStream1 = new FileInputStream(inputFile2);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile1)) {
            while (fileInputStream.available() > 0) {
                fileOutputStream.write(fileInputStream.read());
            }
            while (fileInputStream1.available() > 0) {
                fileOutputStream.write(fileInputStream1.read());
            }
        }

    }
}
