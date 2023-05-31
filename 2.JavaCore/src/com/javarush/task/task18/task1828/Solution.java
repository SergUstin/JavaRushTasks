package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.*;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new LinkedHashMap<>();
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String id = "";
            String value = "";
            while (reader.ready()) {
                String string = reader.readLine();
                id = string.substring(0, 8);
                value = string.substring(8);
                map.put(id, value);
            }
            System.out.println(map);
            if (args.length != 0) {
                if (args[0].equals("-u")) {
                    String productName = checkLength(args[1], 30);
                    String price = checkLength(args[2], 8);
                    String quantity = checkLength(args[3], 4);
                    map.replace(id, value, productName + price + quantity);
                }
                System.out.println(map);
            }
        }
    }

    public static String checkLength(String string, int limit) {
        StringBuilder builder = new StringBuilder(string);
        if (string.length() > limit) {
            return string.substring(0, limit);
        } else {
            while (builder.length() != limit) {
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
