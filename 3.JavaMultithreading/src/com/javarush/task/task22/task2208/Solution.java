package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russian");
        map.put("city", "Moscow");
        map.put("age", null);

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (String string : params.keySet()) {
            String value = params.get(string);
            if (value == null) {
                continue;
            }
            if (builder.toString().length() != 0) {
                builder.append(" and ");
            }
            builder.append(string + " = '" + value + "'");
        }
        return builder.toString();
    }
}
