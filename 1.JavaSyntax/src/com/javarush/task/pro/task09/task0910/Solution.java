package com.javarush.task.pro.task09.task0910;

/* 
Кодировка Unicode
*/

public class Solution {
    public static void main(String[] args) {
        char[] symbols = new char[9];
        init(symbols);
        System.out.println(new String(symbols));
    }

    public static void init(char[] symbols) {
        for (int i = 0; i < symbols.length; i++) {
            switch (i) {
                case (0) -> symbols[i] = '\u00A9';
                case (1) -> symbols[i] = '\u004A';
                case (2) -> symbols[i] = '\u0061';
                case (3) -> symbols[i] = '\u0076';
                case (4) -> symbols[i] = '\u0061';
                case (5) -> symbols[i] = '\u0052';
                case (6) -> symbols[i] = '\u0075';
                case (7) -> symbols[i] = '\u0073';
                case (8) -> symbols[i] = '\u0068';
            }
        }
    }
}
