package com.javarush.task.pro.task04.task0406;

import java.util.Scanner;

/* 
Показываем, что получаем
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println(number);
            } else if (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.equalsIgnoreCase("enough")){
                    break;
                }
            }
        }

    }
}