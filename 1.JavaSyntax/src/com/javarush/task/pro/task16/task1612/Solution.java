package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> localDateTimeSet = new HashSet<>();
        for (Map.Entry<LocalDate, List<LocalTime>> localDateListEntry : sourceMap.entrySet()) {
            for (int i = 0; i < localDateListEntry.getValue().size(); i++) {
                LocalTime localTime = localDateListEntry.getValue().get(i);
                LocalDate localDate = localDateListEntry.getKey();
                localDateTimeSet.add(LocalDateTime.of(localDate, localTime));
            }
        }

        return localDateTimeSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}