package com.javarush.task.pro.task02.task0214;

import java.util.Scanner;

/* 
Чтение и преобразование строк
*/

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        String c = s.nextLine();

        System.out.println(c);
        System.out.println(b.toUpperCase());
        System.out.println(a.toLowerCase());

    }
}
