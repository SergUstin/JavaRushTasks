package com.javarush.task.pro.task03.task0305;

import java.util.Scanner;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        if (a == c && a == b) {
            System.out.print(a + " ");
            System.out.print(b + " ");
            System.out.println(c);
        } else if (a == b) {
            System.out.print(a + " ");
            System.out.println(b);
        } else if (b == c) {
            System.out.print(b + " ");
            System.out.print(c);
        } else if (c == a) {
            System.out.print(a + " ");
            System.out.print(c);
        }
    }
}
