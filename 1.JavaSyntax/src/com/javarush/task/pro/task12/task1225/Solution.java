package com.javarush.task.pro.task12.task1225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Аккаунт ИнстаМатрицы
*/

public class Solution {

    public static ArrayList<String> accountsList = new ArrayList<>();

    public static void main(String[] args) {
        convertAccounts();
        registerAccount("Амиго");
        registerAccount("Диего");

        for (String string : accountsList) {
            System.out.println(string);
        }
    }

    public static void convertAccounts() {
        Collections.addAll(accountsList, Accounts.getAccounts());
    }

    public static void registerAccount(String username) {
        if (!accountsList.contains(username)) {
            accountsList.add(username);
        }
    }
}