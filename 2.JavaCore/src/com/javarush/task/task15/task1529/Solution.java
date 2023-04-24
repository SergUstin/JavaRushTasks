package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() throws IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String passanger = reader.readLine();
            if (passanger.equals("helicopter")) {
                result = new Helicopter();
            }
            if (passanger.equals( "plane")) {
                passanger = reader.readLine();
                result = new Plane(Integer.parseInt(passanger));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
