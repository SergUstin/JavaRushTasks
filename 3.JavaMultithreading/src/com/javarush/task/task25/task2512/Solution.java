package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> listExeption = new LinkedList<>();
        while (e != null) {
            listExeption.add(0, e.toString());
            e = e.getCause();
        }

        for (String s : listExeption) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
    }
}
