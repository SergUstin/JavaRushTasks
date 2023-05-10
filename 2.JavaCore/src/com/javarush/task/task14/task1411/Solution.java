package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key;

        while (true) {
            key = reader.readLine();
            if (!key.equalsIgnoreCase("user") && !key.equalsIgnoreCase("loser") &&
                    !key.equalsIgnoreCase("coder") && !key.equalsIgnoreCase("proger")) {
                return;
            }

            switch (key) {
                case "user":
                    person = new Person.User();
                    break;
                case "loser":
                    person = new Person.Loser();
                    break;
                case "coder":
                    person = new Person.Coder();
                    break;
                case "proger":
                    person = new Person.Proger();
                    break;
            }
            doWork(person); //вызываем doWork
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            new Person.User().live();
        } else if (person instanceof Person.Loser) {
            new Person.Loser().doNothing();
        } else if (person instanceof Person.Coder) {
            new Person.Coder().writeCode();
        } else if (person instanceof Person.Proger) {
            new Person.Proger().enjoy();
        }
    }
}
