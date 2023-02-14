package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Student1", 4.5);
        grades.put("Student2", 4.9);
        grades.put("Student3", 4.2);
        grades.put("Student4", 3.5);
        grades.put("Student5", 1.5);

    }
}
