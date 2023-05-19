package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int countComma = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream file = new FileInputStream(reader.readLine())) {
            while (file.available() > 0) {
                if (file.read() == 44) {
                    countComma++;
                }
            }
        }
        System.out.println(countComma);
    }
}
