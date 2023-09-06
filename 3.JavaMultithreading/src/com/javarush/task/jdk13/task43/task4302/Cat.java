package com.javarush.task.jdk13.task43.task4302;

/* 
Сравниваем котов
*/

//import org.apache.commons.lang3.builder.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Cat {

    private String name;
    private int age;
    private transient int weight;
    private transient String breed;

    public Cat(String name, int age, int weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        return EqualsBuilder.reflectionEquals(this, obj, "name", "weight");
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(age).append(breed).toHashCode();
    }
}
