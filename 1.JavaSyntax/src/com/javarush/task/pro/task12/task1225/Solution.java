package com.javarush.task.pro.task12.task1225;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Аккаунт ИнстаМатрицы
*/

public class Solution {

    public static ArrayList<String> accountsList = new ArrayList<>();

    public static void main(String[] args) {
        convertAccounts();
        registerAccount(Arrays.toString(Accounts.getAccounts()));
        System.out.println(accountsList);
    }

    public static void convertAccounts() {
        for (int i = 0; i < Accounts.getAccounts().length; i++) {
            accountsList.add(Arrays.toString(Accounts.getAccounts()));
        }
    }

    public static void registerAccount(String username) {
        if (accountsList.contains(username)) {
            accountsList.add(username);
        }
    }
}