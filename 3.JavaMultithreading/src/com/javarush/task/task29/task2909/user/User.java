package com.javarush.task.task29.task2909.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String name;
    String surname;
    int age;

    @Setter(AccessLevel.PRIVATE)
    Address address;

    Work work;

    boolean man;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        this.address.setCountry(country);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public void printAdditionalInfo() {
        System.out.println("Пользователь " + (getAge() < 16 ? "моложе" : "старше") + " 16 лет");
    }

    public void printInfo() {
        System.out.println("Имя: " + getName() + "\n" + "Фамилия: " + getSurname());
    }

    public String getBoss() {
        return work.getBoss();
    }
}