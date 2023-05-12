package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int max = inputStream.read();

        while (inputStream.available() > 0) {
            int min = inputStream.read();
            if (min > max) {
                max = min;
            }
        }
        inputStream.close();
        System.out.println(max);
    }
}
