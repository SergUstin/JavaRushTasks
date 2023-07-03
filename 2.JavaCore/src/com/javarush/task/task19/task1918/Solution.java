package com.javarush.task.task19.task1918;

import java.io.*;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
        }

        try (FileWriter writer = new FileWriter(builder.toString())) {

        }
    }
}
