package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        String outputFile;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
            outputFile = reader.readLine();
        }

        ArrayList<Integer> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(inputFile)) {
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
        }

        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            for (int i = 1; i < list.size(); i += 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        }
    }
}
