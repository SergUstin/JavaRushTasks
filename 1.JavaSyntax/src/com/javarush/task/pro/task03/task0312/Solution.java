package com.javarush.task.pro.task03.task0312;

import java.util.Scanner;

/* 
Сравним строки
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameA = scanner.nextLine();
        String nameB = scanner.nextLine();

        if (nameA.equals(nameB))
        System.out.println("строки одинаковые");
        else
        System.out.println("строки разные");
    }
}
