package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
           return true;
        }

        if (obj == null) {
            return false;
        }

        Iphone iphone = (Iphone) obj;

        if (this.model == null) {
            return false;
        }

        if (this.color == null) {
            return false;
        }

        if (this.price != iphone.price) {
            return false;
        }

        return this.model.equals(iphone.model) && this.color.equals(iphone.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, price);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
