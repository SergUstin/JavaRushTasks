package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] count = new int[128];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                count[reader.read()]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println((char) i + " " + count[i]);
            }
        }

    }
}
