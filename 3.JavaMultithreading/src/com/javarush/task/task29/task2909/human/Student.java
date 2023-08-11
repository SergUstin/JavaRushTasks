package com.javarush.task.task29.task2909.human;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends UniversityPerson {

    @Getter
    int course;
    @Getter
    double averageGrade;
    Date endOfSession;
    Date beginningOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    @Override
    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}