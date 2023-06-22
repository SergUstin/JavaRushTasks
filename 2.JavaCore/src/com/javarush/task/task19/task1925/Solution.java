package com.javarush.task.task19.task1925;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Длинные слова
*/

public class Solution {
    public static void main1(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String[] split = reader.readLine().split("\\s");
                for (String word : split) {
                    if (word.length() > 6) {
                        builder.append(word).append(",");
                    }
                }
            }
//            writer.write(builder.substring(0, builder.length() - 1));
            writer.write(builder.toString().replaceAll(",$", ""));
        }
    }

    public static void main(String[] args) throws IOException {
//        String string = Files.readString(Path.of(args[0]));
//        String[] split = string.split("[\\s\\n]*");
//        String collect = Arrays.stream(split).filter(word -> word.length() > 6).collect(Collectors.joining(","));
//        Files.writeString(Path.of(args[1]), collect.replaceAll(",$", ""));

//        Files.writeString(Path.of(args[1]),
//                Arrays.stream(Files.readString(Path.of(args[0])).split("[\\s\\n]*"))
//                        .filter(word -> word.length() > 6)
//                        .collect(Collectors.joining(","))
//                .replaceAll(",$", ""));
    }
}
