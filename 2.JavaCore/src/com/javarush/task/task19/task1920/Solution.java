package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main1(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        String fileName = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double current = 0;
                String[] split = line.split(" ");
                String name = split[0];
                double item = Double.parseDouble(split[1]);
                if (map.containsKey(name)) {
                    current = map.get(name);
                    map.put(name, item + current);
                } else {
                    map.put(name, item);
                }
            }
        }

        double max = map.firstEntry().getValue();
        for (Double value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        TreeSet<String> set = new TreeSet<>();
        for (String name : map.keySet()) {
            if (max == map.get(name)) {
                set.add(name);
            }
        }

        for (String name : set) {
            System.out.println(name);
        }

    }

    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();

        Files.readAllLines(Path.of(args[0])).stream()
                .map(str -> str.split(" "))
                .forEach(strings -> map.merge(strings[0], Double.parseDouble(strings[1]), Double::sum));

        map.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), map.values().stream().max(Double::compare).orElseThrow()))
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}
