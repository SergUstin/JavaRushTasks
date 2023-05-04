package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] byteCountArray = new int[256];


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            while (inputStream.available() > 0) {
                byteCountArray[inputStream.read()]++;
            }
        }
    }
}
