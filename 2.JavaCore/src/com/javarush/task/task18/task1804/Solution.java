package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые редкие байты
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

        int min = Integer.MAX_VALUE;

        for (int j : byteCountArray) {
            if (j > 0 && min > j) {
                min = j;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] == min) {
                list.add(i);
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
