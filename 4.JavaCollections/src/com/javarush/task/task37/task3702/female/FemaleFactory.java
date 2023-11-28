package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

public class FemaleFactory {

    public Human getPerson(int age) {
        Human human = null;
        if (age <= KidGirl.MAX_AGE) {
            human = new KidGirl();
        } else if (age <= TeenGirl.MAX_AGE) {
            human = new TeenGirl();
        } else
            human = new Woman();
        return human;
    }
}
