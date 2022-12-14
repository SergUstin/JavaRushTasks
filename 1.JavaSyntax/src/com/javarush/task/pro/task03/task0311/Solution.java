package com.javarush.task.pro.task03.task0311;

import java.util.Scanner;

/* 
Высокая точность
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numA = scanner.nextDouble();
        double numB = scanner.nextDouble();

        if (Math.abs(numB - numA) < 0.000001){
            System.out.println("числа равны");
        }else {
            System.out.println("числа не равны");
        }
    }
}
