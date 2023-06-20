package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader1 = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(console.readLine()))) {
            while (fileReader1.ready()) {
                listOne.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                listTwo.add(fileReader2.readLine());
            }
        }

        while (listOne.size() > 0 & listTwo.size() > 0) {
            if (listOne.get(0).equals(listTwo.get(0))) {
                lines.add(new LineItem(Type.SAME, listOne.get(0)));
                listOne.remove(0);
                listTwo.remove(0);
            } else if (listOne.get(1).equals(listTwo.get(0))) {
                lines.add(new LineItem(Type.REMOVED, listOne.get(0)));
                listOne.remove(0);
            }else if (listOne.get(0).equals(listTwo.get(1))) {
                lines.add(new LineItem(Type.ADDED, listTwo.get(0)));
                listTwo.remove(0);
            }
        }

        if (listOne.isEmpty()) {
            listTwo.forEach(str -> lines.add(new LineItem(Type.ADDED, str)));
        }
        if (listTwo.isEmpty()) {
            listOne.forEach(str -> lines.add(new LineItem(Type.REMOVED, str)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
