package com.javarush.task.pro.task12.task1228;

/* 
   Только для спасателей!
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> secretMessage = List.of(
            "защ", "ита", "тит", "ити", "e ", "от ", "те ", "пож", "баг", "от ", "алу", "йст", "ужа", "сно", "й ",
            "сны", "е ", "осв", "х г", "обо", "быс", "ала", "кти", "чны", "баг", "ско", "пле", "ов ", "рее", "ние",
            "и ", "реш", "отп", "выз", "ен ", "уск", "вол", "те ", "нос", "ите", "каж", "нет", " из", "но ", "все",
            " ин", "отк", "ите", "ста", "пож", "ар ", "мат", "алу", " бу", "риц", "рат.", "ыт.", "ы.");

    public static void main(String[] args) {
        List<String> decryptedMessage = decryptSecretMessage();

        for (String s : decryptedMessage) {
            System.out.print(s);
        }
    }

    public static List<String> decryptSecretMessage() {
        List<String> decryptedMessage = new ArrayList<>();
        for (int i = 0; i < secretMessage.size(); i++) {
            if (i % 3 == 0) {
                decryptedMessage.add(secretMessage.get(i));
                i--;
            }
        }
        return decryptedMessage;
    }
}