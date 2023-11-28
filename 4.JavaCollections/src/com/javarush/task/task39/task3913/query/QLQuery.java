package com.javarush.task.task39.task3913.query;

import java.util.Set;

public interface QLQuery {
    Set<Object> execute(String query);
}