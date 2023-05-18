package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

        int max = 0;

        for (int i = 0; i < byteCountArray.length; i++) {
            if (max < byteCountArray[i]) {
                max = byteCountArray[i];
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] == max) {
                list.add(i);
            }
        }

        for (Integer integer : list) {
            System.out.println(integer + " ");
        }
    }
}
