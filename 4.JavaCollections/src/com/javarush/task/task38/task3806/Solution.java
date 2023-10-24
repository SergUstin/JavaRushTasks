package com.javarush.task.task38.task3806;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* 
Улучшения в Java 7 (try-with-resources)
*/

public class Solution {
    public void printFile1() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt")) {
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        }
    }

    public void printFile2() throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("file.txt"))) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        }
    }

    public static void main(String[] args) {

    }
}
