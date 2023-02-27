package com.javarush.task.pro.task14.task1422;

/* 
Сбор и сканирование ДНК
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        printDNA();
    }

    public static void printDNA() {
        for (StackTraceElement[] stackTraceElements : getDNA()) {
            StackTraceElement elements = stackTraceElements[1];
            System.out.printf("File name: %s, Method name: %s, Line number: %d\n", elements.getFileName(),
                    elements.getMethodName(), elements.getLineNumber());
        }
    }

    private static List<StackTraceElement[]> getDNA() {
        List<StackTraceElement[]> list = new ArrayList<>();

        list.add(adenine());
        list.add(thymine());
        list.add(cytosine());
        list.add(guanine());

        return list;
    }

    private static StackTraceElement[] adenine() {
        return Thread.currentThread().getStackTrace();
    }

    private static StackTraceElement[] thymine() {
        return Thread.currentThread().getStackTrace();
    }

    private static StackTraceElement[] cytosine() {
        return Thread.currentThread().getStackTrace();
    }

    private static StackTraceElement[] guanine() {
        return Thread.currentThread().getStackTrace();
    }
}