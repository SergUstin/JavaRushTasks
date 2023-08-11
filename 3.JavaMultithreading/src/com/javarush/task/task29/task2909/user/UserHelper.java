package com.javarush.task.task29.task2909.user;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.atomic.AtomicInteger;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserHelper {
    User userAnya = new User("Аня", "Смирнова", 10);
    User userRoma = new User("Рома", "Виноградов", 30);

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);
        return  (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int result = base.get() + age / 100;
        result *= hasWork ? 1.1 : 0.9;
        result *= hasHouse ? 1.1 : 0.9;
        return result;        
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}