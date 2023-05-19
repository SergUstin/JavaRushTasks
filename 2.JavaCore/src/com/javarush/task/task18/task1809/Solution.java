package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream intputFile = new FileInputStream(reader.readLine());
        FileOutputStream outputFile = new FileOutputStream(reader.readLine())) {
            while (intputFile.available() > 0) {
                list.add(intputFile.read());
            }
            Collections.reverse(list);
            for (Integer integer : list) {
                outputFile.write(integer);
            }
        }
    }
}
