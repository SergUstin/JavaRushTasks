package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])) {
            while (reader.ready()) {
                String[] split = reader.readLine().split(" ");
                for (String word : split) {
                    if (word.matches(".*[0-9].*")) {
                        writer.write(word + " ");
                    }
                }
            }
        }

    }
}
