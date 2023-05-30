package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1))) {
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            for (String string : list) {
                bufferedWriter.write(string.replaceAll("\\.", "!"));
            }
        }



    }
}
