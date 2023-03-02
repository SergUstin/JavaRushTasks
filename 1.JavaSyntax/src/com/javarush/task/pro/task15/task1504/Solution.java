package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try (InputStream input = Files.newInputStream(Path.of(scanner.nextLine()));
            OutputStream output = Files.newOutputStream(Path.of(scanner.nextLine()))) {
            byte[] byteIn = input.readAllBytes();
            byte[] byteOut = new byte[byteIn.length];
            for (int i = 0; i < byteIn.length; i += 2) {
                if (i < byteIn.length - 1) {
                    byteOut[i] = byteIn[i + 1];
                    byteOut[i + 1] = byteIn[i];
                } else {
                    byteOut[i] = byteIn[i];
                }
            }
            output.write(byteOut);
        }
    }
}

