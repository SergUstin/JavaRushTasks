package com.javarush.task.task29.task2909.human;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Worker extends Human {
    double salary;
    String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {

    }
}