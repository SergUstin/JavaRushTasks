package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "className")
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}