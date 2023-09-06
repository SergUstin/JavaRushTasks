package com.javarush.task.jdk13.task43.task4307;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/* 
Шило на мыло
*/

public class Solution {

    public static void main(String[] args) {
        String[] array1 = {null, "hello", "ok", null, "bye"};

        printFirstNonNull(array1);
        System.out.println("----------");
        printDefaultValueIfNullObject(array1, "oops");
    }

    public static void printFirstNonNull(final String... values) {
        if (Objects.isNull(values)) {
            System.out.println((Object) null);
        }
        Arrays.stream(values).filter(Objects::nonNull).findFirst().ifPresent(System.out::println);
    }

    public static void printDefaultValueIfNullObject(final String[] values, final String defaultValue) {
        Arrays.stream(values).map(o -> Objects.requireNonNullElse(o, defaultValue)).forEach(System.out::println);
    }
}
