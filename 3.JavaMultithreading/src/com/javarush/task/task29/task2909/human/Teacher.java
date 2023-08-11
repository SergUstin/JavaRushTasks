package com.javarush.task.task29.task2909.human;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher extends UniversityPerson {

    int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public void live() {
        teach();
    }

    public void teach() {
    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }
}