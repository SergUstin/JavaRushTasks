package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String string = console.readLine();
                if (string.equals("end")) {
                    break;
                }
                int index = Integer.parseInt(string.substring(string.lastIndexOf("t") + 1));
                if (!map.containsKey(index)) {
                    map.put(index, string);
                }
            }
        }
        for (String fileName : map.values()) {
            String shortName = fileName.substring(0, fileName.lastIndexOf("."));

            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
                 BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(shortName, true))) {
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read());
                }
            }
        }
    }
}
