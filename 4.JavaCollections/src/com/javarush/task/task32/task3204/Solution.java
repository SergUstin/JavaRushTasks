package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        char[] password = new char[8];
        for (int i = 0; i < password.length; i++) {
            int index = random.nextInt(alphabet.length());
            password[i] = alphabet.charAt(index);
        }
        String string = new String(password);

        System.out.println(string);

        return new ByteArrayOutputStream();
    }
}
