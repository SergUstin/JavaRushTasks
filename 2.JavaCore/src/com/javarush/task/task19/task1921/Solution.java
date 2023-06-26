package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        }

        for (String string : list) {
            String[] split = string.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < split.length - 3; i++) {
                builder.append(split[i]).append(" ");
            }

            int day = Integer.parseInt(split[split.length - 3]);
            int month = Integer.parseInt(split[split.length - 2]) - 1;
            int year = Integer.parseInt(split[split.length - 1]);
            Calendar birthDate = new GregorianCalendar(year, month, day);

            PEOPLE.add(new Person(builder.toString().trim(), birthDate.getTime()));
        }

    }
}
