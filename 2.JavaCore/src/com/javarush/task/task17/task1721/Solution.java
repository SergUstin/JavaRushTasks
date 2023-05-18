package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readFileOne = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader readFileTwo = new BufferedReader(new FileReader(console.readLine()))) {

            while (readFileOne.ready()) {
                allLines.add(readFileOne.readLine());
            }

            while (readFileTwo.ready()) {
                forRemoveLines.add(readFileTwo.readLine());
            }

        }
        Solution solution = new Solution();
        solution.joinData();


    }

    public void joinData() throws CorruptedDataException {
        if (new HashSet<>(allLines).containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
