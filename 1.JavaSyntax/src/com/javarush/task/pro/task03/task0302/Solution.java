package com.javarush.task.pro.task03.task0302;

import java.util.Scanner;

/* 
Призывная кампания
*/

public class Solution {
    public static void main(String[] args) {
        String militaryCommissar = ", явитесь в военкомат";

        Scanner s = new Scanner(System.in);
        //System.out.print("Ваше имя: ");
        String name = s.nextLine();
        //System.out.print("Ваш возвраст: ");
        int age = s.nextInt();


        if (age >= 18 && age <= 28) {
            System.out.println(name + militaryCommissar);
        }
    }
}
