package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        char[] password = new char[8];
        String string = "";

        while (!string.matches(".*\\d.*") || !string.matches(".*[a-z].*")
                || !string.matches(".*[A-Z].*")) {
            for (int i = 0; i < password.length; i++) {
                int index = random.nextInt(alphabet.length());
                password[i] = alphabet.charAt(index);
            }
            string = new String(password);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(string.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return byteArrayOutputStream;
    }
}
