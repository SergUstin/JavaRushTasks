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
        System.out.println(Accounts.getAccounts());
        registerAccount("Амиго");
        registerAccount("Диего");
        //System.out.println(accountsList);
    }

    public static void convertAccounts() {
        accountsList.addAll(Arrays.asList(Accounts.getAccounts()));
    }

    public static void registerAccount(String username) {
        if (accountsList.contains(username)) {
            accountsList.add(username);
        }
    }
}