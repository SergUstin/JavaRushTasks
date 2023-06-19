package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String str;

        try (BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while ((str = reader.readLine()) != null) {
                if (str.startsWith(args[0] + " ")) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}
