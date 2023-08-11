package com.javarush.task.task29.task2909.human;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityPerson extends Human {

    University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }
}
