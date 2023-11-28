package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            String text = bis.readLine();
            return text;
        } catch (IOException ignored) {
            /* NOP */
        }
        return null;
    }

    public static String askCurrencyCode() {
        while (true) {
            ConsoleHelper.writeMessage("Please choose a currency code, for example USD");
            String currencyCode = ConsoleHelper.readString();
            if (currencyCode == null || currencyCode.trim().length() != 3) {
                ConsoleHelper.writeMessage("Please specify valid data.");
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        while (true) {
            ConsoleHelper.writeMessage(String.format("Please specify integer denomination and integer count. For example '10 3' means 30 %s", currencyCode));
            String s = ConsoleHelper.readString();
            String[] split = null;
            if (s == null || (split = s.split(" ")).length != 2) {
                ConsoleHelper.writeMessage("Please specify valid data.");
            } else {
                try {
                    if (Integer.parseInt(split[0]) <= 0 || Integer.parseInt(split[1]) <= 0)
                        ConsoleHelper.writeMessage("Please specify valid data.");
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage("Please specify valid data.");
                    continue;
                }
                return split;
            }
        }
    }

}
